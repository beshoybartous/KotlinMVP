package com.example.kotlinmvp.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.kotlinmvp.ui.dialog.LoadingDialog
import com.example.kotlinmvp.ui.dialog.ProgressDialog
import es.dmoral.toasty.Toasty

abstract class BaseActivity<V : ViewBinding, P : BasePresenter>
    : AppCompatActivity(), BaseView {

    open lateinit var binding: V
    open lateinit var presenter: P

    open lateinit var loadingDialog: LoadingDialog
    open lateinit var progressDialog: ProgressDialog

    abstract fun initBinding(): V

    abstract fun initPresenter(): P

    abstract fun onActivityCreated()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = initBinding()
        setContentView(binding.root)
        presenter = initPresenter()

        loadingDialog = LoadingDialog(this)
        progressDialog = ProgressDialog(this)

        onActivityCreated()
    }

    override fun onDestroy() {
        presenter.clean()
        super.onDestroy()
    }

    override fun showLoading() {
        progressDialog.show()
    }

    override fun hideLoading() {
        progressDialog.dismiss()
    }

    override fun showSuccessMsg(msg: String) {
        Toasty.success(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showErrorMsg(msg: String) {
        Toasty.error(this, msg, Toast.LENGTH_LONG).show()
    }
}