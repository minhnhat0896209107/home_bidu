package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class NameOrganizerX(
    @SerializedName("unsigneduserName")
    val unsigneduserName: String,
    @SerializedName("userName")
    val userName: String
)