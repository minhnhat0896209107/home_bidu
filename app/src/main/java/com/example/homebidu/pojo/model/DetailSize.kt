package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class DetailSize(
    @SerializedName("size_infos")
    val sizeInfos: List<SizeInfo>,
    @SerializedName("type_size")
    val typeSize: String
)