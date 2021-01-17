package com.example.kotlinmvp.model

import com.google.gson.annotations.SerializedName

class ErrorModel(
    @SerializedName("message")
    override var message: String, var code: Int = 0
) : Exception() {
    @SerializedName("name")
    var name: String? = null
}