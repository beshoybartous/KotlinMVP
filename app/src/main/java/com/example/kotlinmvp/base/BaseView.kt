package com.example.kotlinmvp.base

interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun showSuccessMsg(msg: String)

    fun showErrorMsg(msg: String)
}