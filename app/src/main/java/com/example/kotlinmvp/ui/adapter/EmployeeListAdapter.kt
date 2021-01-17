package com.example.kotlinmvp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvp.base.ItemClickListener
import com.example.kotlinmvp.databinding.ItemEmployeeLayoutBinding
import com.example.kotlinmvp.model.EmployeeModel

class EmployeeListAdapter(
    var employeeList: ArrayList<EmployeeModel> = ArrayList(),
    private val itemClickListener: ItemClickListener<EmployeeModel>
) :
    RecyclerView.Adapter<EmployeeListAdapter.EmployeeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListViewHolder {
        return EmployeeListViewHolder(
            ItemEmployeeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeeListViewHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    inner class EmployeeListViewHolder(var binding: ItemEmployeeLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: EmployeeModel) {
            binding.tvName.text = model.employeeName
            binding.tvSalary.text = model.employeeSalary

            binding.root.setOnClickListener { itemClickListener.onItemClicked(model) }
        }
    }
}