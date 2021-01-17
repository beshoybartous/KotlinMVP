package com.example.kotlinmvp.ui.main

import android.content.Intent
import com.example.kotlinmvp.base.BaseActivity
import com.example.kotlinmvp.cache.shared_pref.SharedPref
import com.example.kotlinmvp.databinding.ActivityMainBinding
import com.example.kotlinmvp.model.response.EmployeeListResponse
import com.example.kotlinmvp.ui.employee_list.EmployeeListActivity
import com.example.kotlinmvp.ui.employees_db.EmployeesDBActivity

//class MainActivity : BaseActivity<ActivityMainBinding, MainPresenter>(), MainView {

//    override fun initBinding(): ActivityMainBinding {
//        return ActivityMainBinding.inflate(layoutInflater)
//    }
//
//    override fun initPresenter(): MainPresenter {
//        return MainPresenter(this)
//    }
//
//    override fun onActivityCreated() {
//        SharedPref.setNotificationToken("Hello")
//        binding.btn.setOnClickListener {
//            checkText()
////            presenter.get()
//            startActivity(Intent(this, EmployeeListActivity::class.java))
//        }
//
//        binding.btn2.setOnClickListener {
//            startActivity(Intent(this, EmployeesDBActivity::class.java))
//        }
//    }
//
//    private fun checkText() {
//        val txt: String? = SharedPref.getNotificationToken()
//        if (txt != null) {
//            binding.tv.text = txt
//            SharedPref.setNotificationToken(txt + "1")
//        }
//    }
//
//    override fun onEmployeeReceived(result: EmployeeListResponse) {
//        showSuccessMsg(result.data.size.toString())
//    }
//}

