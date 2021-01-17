package com.example.kotlinmvp

import android.app.Application
import android.content.Context
import es.dmoral.toasty.Toasty

class ApplicationClass : Application() {

    init {
        instance = this
    }

    companion object {
        var instance: ApplicationClass? = null

        fun context(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        Toasty.Config.getInstance().allowQueue(false).apply()
    }
}