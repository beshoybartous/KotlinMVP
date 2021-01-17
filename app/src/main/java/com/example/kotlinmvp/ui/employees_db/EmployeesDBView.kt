package com.example.kotlinmvp.ui.employees_db

import com.example.kotlinmvp.base.BaseView
import com.example.kotlinmvp.model.EmployeeModel
import com.example.kotlinmvp.model.response.EmployeeResponse

interface EmployeesDBView : BaseView {

    fun onEmployeeListReceived(response: ArrayList<EmployeeModel>)

    fun onEmployeeReceived(response: EmployeeResponse)
}