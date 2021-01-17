package com.example.kotlinmvp.ui.employee_list

import com.example.kotlinmvp.base.BaseActivity
import com.example.kotlinmvp.base.ItemClickListener
import com.example.kotlinmvp.databinding.ActivityEmployeeListBinding
import com.example.kotlinmvp.model.EmployeeModel
import com.example.kotlinmvp.model.response.EmployeeListResponse
import com.example.kotlinmvp.model.response.EmployeeResponse
import com.example.kotlinmvp.ui.adapter.EmployeeListAdapter
import com.example.kotlinmvp.ui.bottom_sheet.EmployeeInfoBottomSheet

class EmployeeListActivity : BaseActivity<ActivityEmployeeListBinding, EmployeeListPresenter>(),
    EmployeeListView {

    private lateinit var adapter: EmployeeListAdapter
    private var employeeList: ArrayList<EmployeeModel> = ArrayList()

    override fun initBinding(): ActivityEmployeeListBinding {
        return ActivityEmployeeListBinding.inflate(layoutInflater)
    }

    override fun initPresenter(): EmployeeListPresenter {
        return EmployeeListPresenter(this)
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

        binding.fabAdd.setOnClickListener {
            presenter.createEmployee(
                EmployeeModel(
                    employeeName = "Name",
                    employeeSalary = "55555",
                    employeeAge = "17"
                )
            )
        }
    }

    override fun onEmployeeListReceived(response: EmployeeListResponse) {
        adapter.employeeList = response.data
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