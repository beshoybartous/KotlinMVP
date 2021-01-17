package com.example.kotlinmvp.ui.employee_list

import com.example.kotlinmvp.base.BaseView
import com.example.kotlinmvp.model.response.EmployeeListResponse
import com.example.kotlinmvp.model.response.EmployeeResponse

interface EmployeeListView : BaseView {

    fun onEmployeeListReceived(response: EmployeeListResponse)

    fun onEmployeeReceived(response: EmployeeResponse)
}