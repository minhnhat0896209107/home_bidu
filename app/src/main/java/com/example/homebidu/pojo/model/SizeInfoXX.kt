package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class SizeInfoXX(
    @SerializedName("name")
    val name: String,
    @SerializedName("unit")
    val unit: String
)