package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class TopKeyword(
    @SerializedName("avatar")
    val avatar: String ?= null,
    @SerializedName("count_number")
    val countNumber: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("keyword")
    val keyword: String,
    @SerializedName("shop_id")
    val shopId: Any,
    @SerializedName("total_product")
    val totalProduct: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)