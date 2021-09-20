package com.example.homebidu.pojo.repo

import com.example.homebidu.pojo.di.ProductService
import com.example.homebidu.pojo.model.Product
import com.example.homebidu.pojo.model.SystemCategory
import retrofit2.Call
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService: ProductService
) {
    fun getProduct() : Call<Product> {
        return productService.getProduct()
    }
}