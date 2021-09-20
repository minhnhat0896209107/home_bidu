package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("size_infos")
    val sizeInfos: List<SizeInfoXX>,
    @SerializedName("type_size")
    val typeSize: String
)