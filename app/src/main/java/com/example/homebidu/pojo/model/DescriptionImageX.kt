package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class DescriptionImageX(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)