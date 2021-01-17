package com.example.kotlinmvp.base

import com.example.kotlinmvp.model.ErrorModel
import com.example.kotlinmvp.model.response.ErrorResponse
import com.example.kotlinmvp.network.NetworkManager
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.io.IOException


abstract class BasePresenter(open val view: BaseView) {
    private val job = SupervisorJob()
    val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    var networkManager: NetworkManager? = null

    init {
        networkManager = NetworkManager()
    }

    inline fun CoroutineScope.launchCatching(
        noinline block: suspend CoroutineScope.() -> Unit,
        crossinline onError: (Throwable) -> Unit
    ) {
        launch(
            CoroutineExceptionHandler { _, throwable -> onError(throwable) },
            block = block
        )
    }

    fun handleError(t: Throwable) {
        val error: ErrorModel = when (t) {
            is ErrorModel -> {
                t
            }
            is HttpException -> {
                getHttpErrorMessage(t)
            }
            is IOException -> {
                ErrorModel("Something Went Wrong")
            }
            else -> {
                ErrorModel("Something Went Wrong")
            }
        }

        view.hideLoading()
        view.showErrorMsg(error.message)
    }

    private fun getHttpErrorMessage(t: HttpException): ErrorModel {
        val gson = Gson()

        if (t.response()?.errorBody() != null) {
            val errorResponse: ErrorResponse = gson.fromJson(
                t.response()!!.errorBody()!!.string(),
                ErrorResponse::class.java
            )
                ?: return ErrorModel("Network Error")
            if (errorResponse.message != null)
                return ErrorModel(errorResponse.message)
        }

        return ErrorModel("Network Error")
    }

    fun clean() {
        job.cancel()
    }
}
