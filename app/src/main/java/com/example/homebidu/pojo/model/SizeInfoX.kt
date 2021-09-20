package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class SizeInfoX(
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("unit")
    val unit: String
)