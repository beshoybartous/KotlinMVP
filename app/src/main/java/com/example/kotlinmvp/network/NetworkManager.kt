package com.example.kotlinmvp.network

import com.example.kotlinmvp.model.ErrorModel
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import java.util.*

class NetworkManager {

    private var headers: Map<String, String> =
        object : HashMap<String, String>() {
            init {
                put("Accept", "application/json")
            }
        }

    suspend fun <T> getRequest(
        api: String,
        param: Map<String, Any> = hashMapOf(),
        parseClass: Class<T>
    ): T {
        return withContext(Dispatchers.IO) {
            parseResponse(
                ApiClient.getRetrofit().create(
                    APIService::class.java
                ).getRequest(api, headers, param), parseClass
            )
        }
    }

    suspend fun <T> postRequest(
        api: String,
        body: Map<String, Any> = HashMap(),
        parseClass: Class<T>
    ): T {
        return withContext(Dispatchers.IO) {
            parseResponse(
                ApiClient.getRetrofit().create(
                    APIService::class.java
                ).postRequest(api, headers, body), parseClass
            )
        }
    }

    suspend fun <T> putRequest(
        api: String,
        body: Map<String, Any> = HashMap(),
        parseClass: Class<T>
    ): T {
        return withContext(Dispatchers.IO) {
            parseResponse(
                ApiClient.getRetrofit().create(
                    APIService::class.java
                ).putRequest(api, headers, body), parseClass
            )
        }
    }

    suspend fun <T> deleteRequest(
        api: String,
        param: Map<String, Any> = HashMap(),
        parseClass: Class<T>
    ): T {
        return withContext(Dispatchers.IO) {
            parseResponse(
                ApiClient.getRetrofit().create(
                    APIService::class.java
                ).deleteRequest(api, headers, param), parseClass
            )
        }
    }

    suspend fun <T> postMultiPart(
        api: String,
        body: Map<String, Any> = HashMap(),
        file: MultipartBody.Part,
        parseClass: Class<T>
    ): T {
        return withContext(Dispatchers.IO) {
            parseResponse(
                ApiClient.getRetrofit().create(
                    APIService::class.java
                ).postMultiPart(api, headers, body, file), parseClass
            )
        }
    }

    @Throws(
        ErrorModel::class,
        IOException::class,
        InstantiationException::class,
        IllegalAccessException::class,
        JSONException::class
    )
    private fun <T> parseResponse(
        response: Response<JsonElement>,
        parseClass: Class<T>
    ): T {
        return try {
            val gson = GsonBuilder().serializeNulls().create()
            if (!response.isSuccessful) {
                var errorMsg = ""
                if (response.errorBody() != null) {
                    val obj = JSONObject(response.errorBody()!!.string())
                    errorMsg = obj["message"].toString()
                }
                throw ErrorModel(errorMsg, response.code())
            } else {
                gson.fromJson(response.body()!!.asJsonObject, parseClass)
            }
        } catch (e: Exception) {
            throw e
        }
    }
}