package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class ImageX(
    @SerializedName("detail")
    val detail: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("middle")
    val middle: String,
    @SerializedName("top")
    val top: String
)