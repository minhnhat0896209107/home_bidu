package com.example.homebidu.pojo.di

import androidx.lifecycle.ViewModel
import com.example.homebidu.pojo.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ModuleProduct {

    @Singleton
    @Provides
    fun productRetrofit() : Retrofit{
       return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getProduct(retrofit: Retrofit) : ProductService{
        return retrofit.create(ProductService::class.java)
    }
}