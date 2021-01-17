package com.example.kotlinmvp.ui.employees_db

import com.example.kotlinmvp.base.BaseActivity
import com.example.kotlinmvp.base.ItemClickListener
import com.example.kotlinmvp.databinding.ActivityEmployeesDBBinding
import com.example.kotlinmvp.model.EmployeeModel
import com.example.kotlinmvp.model.response.EmployeeResponse
import com.example.kotlinmvp.ui.adapter.EmployeeListAdapter
import com.example.kotlinmvp.ui.bottom_sheet.EmployeeInfoBottomSheet

class EmployeesDBActivity : BaseActivity<ActivityEmployeesDBBinding, EmployeesDBPresenter>(),
    EmployeesDBView {

    private lateinit var adapter: EmployeeListAdapter
    private var employeeList: ArrayList<EmployeeModel> = ArrayList()

    override fun initBinding(): ActivityEmployeesDBBinding {
        return ActivityEmployeesDBBinding.inflate(layoutInflater)
    }

    override fun initPresenter(): EmployeesDBPresenter {
        return EmployeesDBPresenter(this)
    }

    override fun onActivityCreated() {
        presenter.getEmployeeList()

        adapter = EmployeeListAdapter(
            employeeList,
            object : ItemClickListener<EmployeeModel> {
                override fun onItemClicked(model: EmployeeModel, action: Int) {
                    model.id?.let { presenter.getEmployee(it) }
                }
            })
        binding.rvEmployeeList.adapter = adapter
    }

    override fun onEmployeeListReceived(response: ArrayList<EmployeeModel>) {
        adapter.employeeList = response
        adapter.notifyDataSetChanged()
    }

    override fun onEmployeeReceived(response: EmployeeResponse) {
        val employeeInfoBottomSheet =
            EmployeeInfoBottomSheet(response.data, object : ItemClickListener<EmployeeModel> {
                override fun onItemClicked(model: EmployeeModel, action: Int) {
                    model.id?.let { presenter.deleteEmployee(it) }
                }
            })
        if (!employeeInfoBottomSheet.isAdded)
            employeeInfoBottomSheet.show(supportFragmentManager, employeeInfoBottomSheet.tag)
    }

}