package com.example.kotlinmvp.model.response

import com.example.kotlinmvp.model.EmployeeModel
import com.google.gson.annotations.SerializedName

data class EmployeeListResponse(
    @SerializedName("status") var status: String,
    @SerializedName("data") var data: ArrayList<EmployeeModel>
)