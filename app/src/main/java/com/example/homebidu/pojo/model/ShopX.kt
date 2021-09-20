package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class ShopX(
    @SerializedName("country")
    val country: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_approved")
    val isApproved: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("pause_mode")
    val pauseMode: Boolean,
    @SerializedName("refund_conditions")
    val refundConditions: List<RefundConditionXXX>,
    @SerializedName("refund_money_mode")
    val refundMoneyMode: Boolean,
    @SerializedName("refund_money_regulations")
    val refundMoneyRegulations: Any,
    @SerializedName("shipping_methods")
    val shippingMethods: List<ShippingMethodX>,
    @SerializedName("shop_type")
    val shopType: Int,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: String
)