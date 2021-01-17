package com.example.kotlinmvp.ui.employee_list

import com.example.kotlinmvp.base.BasePresenter
import com.example.kotlinmvp.cache.database.AppDatabase
import com.example.kotlinmvp.model.EmployeeModel
import com.example.kotlinmvp.model.entity.EmployeeEntity
import com.example.kotlinmvp.model.response.EmployeeListResponse
import com.example.kotlinmvp.model.response.EmployeeResponse
import com.example.kotlinmvp.model.response.MessageResponse
import com.example.kotlinmvp.network.Endpoints

class EmployeeListPresenter(override val view: EmployeeListView) : BasePresenter(view) {

    fun getEmployeeList() {
        view.showLoading()
        coroutineScope.launchCatching(
            block = {
                val res = networkManager?.getRequest(
                    api = Endpoints.EMPLOYEES,
                    parseClass = EmployeeListResponse::class.java
                )
                res?.let { view.onEmployeeListReceived(it) }
                res?.let { saveList(response = it) }
                view.hideLoading()
            },
            onError = ::handleError
        )
    }

    private suspend fun saveList(response: EmployeeListResponse) {
      //  AppDatabase.DatabaseBuilder.getInstance().employeeDao()
           // .insertAll(EmployeeEntity.toEntityList(response.data))
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

