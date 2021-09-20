package com.example.homebidu.pojo.model


import com.google.gson.annotations.SerializedName

data class Feedback(
    @SerializedName("averageFeedbackRate")
    val averageFeedbackRate: Float
)