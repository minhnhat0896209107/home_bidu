package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class OrderItem(
    @SerializedName("sold")
    val sold: Int
)