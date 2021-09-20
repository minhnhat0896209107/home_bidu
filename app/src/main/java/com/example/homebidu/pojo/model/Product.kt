package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("data")
    val data: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)