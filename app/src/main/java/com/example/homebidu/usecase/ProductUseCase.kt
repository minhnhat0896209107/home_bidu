package com.example.homebidu.usecase

import com.example.homebidu.pojo.model.Product
import com.example.homebidu.pojo.repo.ProductRepository
import retrofit2.Call
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val productUseCase: ProductRepository
) {
    fun excute() : Call<Product> {
        return productUseCase.getProduct()
    }
}