package com.example.kotlinmvp.model.response

import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @SerializedName("status") var status: String,
    @SerializedName("message") var message: String
)