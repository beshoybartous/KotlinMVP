package com.example.kotlinmvp.ui.main

import com.example.kotlinmvp.base.BaseView
import com.example.kotlinmvp.model.response.EmployeeListResponse

interface MainView : BaseView {

    fun onEmployeeReceived(result: EmployeeListResponse)
}