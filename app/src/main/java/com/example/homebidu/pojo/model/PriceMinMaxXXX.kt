package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class PriceMinMaxXXX(
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int
)