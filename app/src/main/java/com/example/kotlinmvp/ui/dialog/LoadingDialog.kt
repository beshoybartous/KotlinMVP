package com.example.kotlinmvp.ui.dialog

import android.app.ProgressDialog
import android.content.Context

class LoadingDialog(var context: Context) {
    private var progressDialog: ProgressDialog? = null

    fun show() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(context)

            progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progressDialog!!.isIndeterminate = true
            progressDialog!!.setCancelable(false)
        }

        progressDialog!!.setMessage("Loading...")
        progressDialog!!.show()
    }

    fun dismiss() {
        if (progressDialog == null) return
        try {
            if (progressDialog!!.isShowing) progressDialog!!.dismiss()
        } catch (e: Exception) {
        }
    }

    fun isShowing(): Boolean {
        return if (progressDialog == null) false else progressDialog!!.isShowing
    }
}