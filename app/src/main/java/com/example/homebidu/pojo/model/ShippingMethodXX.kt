package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class ShippingMethodXX(
    @SerializedName("code")
    val code: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_query")
    val nameQuery: String,
    @SerializedName("pick_address")
    val pickAddress: Any,
    @SerializedName("shipping_method_id")
    val shippingMethodId: String,
    @SerializedName("token")
    val token: String
)