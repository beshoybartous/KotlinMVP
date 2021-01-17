package com.example.kotlinmvp.base

import android.app.Dialog
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.kotlinmvp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheet<V : ViewBinding> : BottomSheetDialogFragment() {

    open lateinit var binding: V

    abstract fun initBinding(): V

    abstract fun onBottomSheetCreated()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        binding = initBinding()

        dialog.setContentView(binding.root)

        onBottomSheetCreated()

        return dialog;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        binding = null
    }
}