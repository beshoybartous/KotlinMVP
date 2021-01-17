package com.example.kotlinmvp.ui.employees_db

import com.example.kotlinmvp.base.BasePresenter
import com.example.kotlinmvp.cache.database.AppDatabase
import com.example.kotlinmvp.model.EmployeeModel
import com.example.kotlinmvp.model.response.EmployeeResponse
import com.example.kotlinmvp.model.response.MessageResponse
import com.example.kotlinmvp.network.Endpoints

class EmployeesDBPresenter(override val view: EmployeesDBView) : BasePresenter(view) {

    fun getEmployeeList() {
//        view.showLoading()
//        coroutineScope.launchCatching(
//            block = {
//                val res = AppDatabase.DatabaseBuilder.getInstance().employeeDao().getAll()
//                view.onEmployeeListReceived(EmployeeModel.toModelList(res))
//                view.hideLoading()
//            },
//            onError = ::handleError
//        )
    }

    fun getEmployee(id: String) {
        view.showLoading()
        coroutineScope.launchCatching(
            block = {
                val res = networkManager?.getRequest(
                    api = Endpoints.EMPLOYEE + id,
                    parseClass = EmployeeResponse::class.java
                )
                res?.let { view.onEmployeeReceived(it) }
                view.hideLoading()
            },
            onError = ::handleError
        )
    }

    fun createEmployee(model: EmployeeModel) {
        view.showLoading()
        coroutineScope.launchCatching(
            block = {
                val res = networkManager?.postRequest(
                    api = Endpoints.CREATE,
                    body = model.toMap(),
                    parseClass = EmployeeResponse::class.java
                )
                getEmployeeList()
            },
            onError = ::handleError
        )
    }

    fun deleteEmployee(id: String) {
        view.showLoading()
        coroutineScope.launchCatching(
            block = {
                val res = networkManager?.deleteRequest(
                    api = Endpoints.DELETE + id,
                    parseClass = MessageResponse::class.java
                )
                getEmployeeList()
            },
            onError = ::handleError
        )
    }
}

