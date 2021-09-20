package com.example.homebidu.activity

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homebidu.pojo.model.*
import com.example.homebidu.usecase.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel @ViewModelInject constructor(
    private val productUseCase: ProductUseCase
) : ViewModel() {

    private val _product = MutableLiveData<ProductState>()
    val product : LiveData<ProductState> = _product

    fun getProduct(){
        productUseCase.excute()
            .enqueue(object : Callback<Product>{
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    _product.postValue(response.body()?.data?.let { ProductState.Success(it) })
                }

                override fun onFailure(call: Call<Product>, t: Throwable) {
                    _product.postValue(ProductState.Error(t.message.toString()))
                }

            })
    }

    sealed class ProductState{
        class Success(var items: Data) : ProductState()
        class Error(var message: String) : ProductState()
    }
}