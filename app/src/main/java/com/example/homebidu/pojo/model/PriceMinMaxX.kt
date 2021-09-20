package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class PriceMinMaxX(
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int
)