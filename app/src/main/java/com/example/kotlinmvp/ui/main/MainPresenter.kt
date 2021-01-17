package com.example.kotlinmvp.ui.main

import com.example.kotlinmvp.base.BasePresenter
import com.example.kotlinmvp.model.response.EmployeeListResponse
import com.example.kotlinmvp.network.Endpoints

class MainPresenter(override val view: MainView) : BasePresenter(view) {

    fun get() {
        view.showLoading()
        coroutineScope.launchCatching(
            block = {
                val res = networkManager?.getRequest(
                    api = Endpoints.EMPLOYEES,
                    parseClass = EmployeeListResponse::class.java
                )
                res?.let { view.onEmployeeReceived(it) }
                view.hideLoading()
            },
            onError = ::handleError
        )
    }
}

