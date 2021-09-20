package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class SystemBanner(
    @SerializedName("_id")
    val id: String,
    @SerializedName("images")
    val imageAds: List<ImageAd>,

)