package com.example.kotlinmvp.ui.bottom_sheet

import com.example.kotlinmvp.base.BaseBottomSheet
import com.example.kotlinmvp.base.ItemClickListener
import com.example.kotlinmvp.databinding.BottomSheetEmployeeInfoAyoutBinding
import com.example.kotlinmvp.model.EmployeeModel

class EmployeeInfoBottomSheet(
    private val employee: EmployeeModel,
    private val itemClickListener: ItemClickListener<EmployeeModel>
) :
    BaseBottomSheet<BottomSheetEmployeeInfoAyoutBinding>() {

    override fun initBinding(): BottomSheetEmployeeInfoAyoutBinding {
        return BottomSheetEmployeeInfoAyoutBinding.inflate(layoutInflater)
    }

    override fun onBottomSheetCreated() {
        binding.tvName.text = employee.employeeName
        binding.tvAge.text = employee.employeeAge
        binding.tvSalary.text = employee.employeeSalary

        binding.btnEdit.setOnClickListener {
            itemClickListener.onItemClicked(employee, 0)
            dismiss()
        }
        binding.btnDelete.setOnClickListener {
            itemClickListener.onItemClicked(employee, 1)
            dismiss()
        }
    }
}