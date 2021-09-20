package com.example.homebidu.pojo.di

import com.example.homebidu.pojo.model.Product
import com.example.homebidu.pojo.model.SystemCategory
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("v2/mobile/home")
    fun getProduct(): Call<Product>
}