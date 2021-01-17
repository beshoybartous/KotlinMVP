package com.example.kotlinmvp.model.response

import com.example.kotlinmvp.model.EmployeeModel
import com.google.gson.annotations.SerializedName

data class EmployeeResponse(
    @SerializedName("status") var status: String,
    @SerializedName("data") var data: EmployeeModel
)