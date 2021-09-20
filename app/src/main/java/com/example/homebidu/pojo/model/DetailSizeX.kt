package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class DetailSizeX(
    @SerializedName("size_infos")
    val sizeInfos: List<SizeInfoX>,
    @SerializedName("type_size")
    val typeSize: String
)