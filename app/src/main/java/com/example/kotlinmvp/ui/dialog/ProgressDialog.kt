package com.example.kotlinmvp.ui.dialog

import android.content.Context
import com.example.kotlinmvp.base.BaseDialog
import com.example.kotlinmvp.databinding.DialogProgressLayoutBinding

class ProgressDialog(context: Context) : BaseDialog<DialogProgressLayoutBinding>(context) {

    override fun initBinding(): DialogProgressLayoutBinding {
        return DialogProgressLayoutBinding.inflate(layoutInflater)
    }

    override fun onDialogCreated() {
        setCancelable(false)
    }
}