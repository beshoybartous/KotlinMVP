package com.example.kotlinmvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.kotlinmvp.ui.dialog.LoadingDialog
import com.example.kotlinmvp.ui.dialog.ProgressDialog
import es.dmoral.toasty.Toasty

abstract class BaseFragment<V : ViewBinding, P : BasePresenter>
    : Fragment(), BaseView {

    open lateinit var binding: V
    open lateinit var presenter: P

    open lateinit var loadingDialog: LoadingDialog
    open lateinit var progressDialog: ProgressDialog

    abstract fun initBinding(): V

    abstract fun initPresenter(): P

    abstract fun onFragmentCreated()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = initBinding()
        presenter = initPresenter()

        if (context != null) {
            loadingDialog = LoadingDialog(requireContext())
            progressDialog = ProgressDialog(requireContext())
        }

        onFragmentCreated()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        binding = null
        presenter.clean();
    }

    override fun showLoading() {
        progressDialog.show()
    }

    override fun hideLoading() {
        progressDialog.dismiss()
    }

    override fun showSuccessMsg(msg: String) {
        if (context != null)
            Toasty.success(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

    override fun showErrorMsg(msg: String) {
        if (context != null)
            Toasty.error(requireContext(), msg, Toast.LENGTH_LONG).show()
    }
}