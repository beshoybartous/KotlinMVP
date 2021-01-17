package com.example.kotlinmvp.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ErrorResponse {
    @SerializedName("success")
    @Expose
    val success: Boolean? = null

    @SerializedName("errors")
    @Expose
    val errors: Any? = null

    @SerializedName("message")
    @Expose
    val message: String? = null
}
