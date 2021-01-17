package com.example.kotlinmvp.model.payload

import com.google.gson.annotations.SerializedName

data class MoviePayLoad(
    @SerializedName( "api_key")
    var apiKey: String? = null,
    @SerializedName( "page")
    var page: Int? = 0
)
val MoviePayLoad.toMap: Map<String, Any>
    get() = mapOf("api_key" to apiKey!!, "page" to page!!)
