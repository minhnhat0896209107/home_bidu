package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class TopLivestream(
    @SerializedName("_id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("products")
    val products: List<ProductX>,
    @SerializedName("user")
    val user: User,

)