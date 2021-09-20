package com.example.homebidu.usecase

import com.example.homebidu.pojo.model.Product
import com.example.homebidu.pojo.repo.ProductRepository
import retrofit2.Call
import javax.inject.Inject

class TopSellerUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    fun excute(): Call<Product> {
        return productRepository.getProduct()
    }
}