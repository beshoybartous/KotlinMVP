package com.example.kotlinmvp.model

import com.example.kotlinmvp.model.entity.EmployeeEntity
import com.google.gson.annotations.SerializedName

data class EmployeeModel(
    @SerializedName("id") var id: String?,
    @SerializedName("employee_name") var employeeName: String,
    @SerializedName("employee_salary") var employeeSalary: String,
    @SerializedName("employee_age") var employeeAge: String,
    @SerializedName("profile_image") var profileImage: String? = null
) {
    companion object {
        private fun toModel(entity: EmployeeEntity): EmployeeModel {
            return EmployeeModel(
                id = entity.id,
                employeeName = entity.employeeName,
                employeeSalary = entity.employeeSalary,
                employeeAge = entity.employeeAge
            )
        }

        fun toModelList(data: List<EmployeeEntity>): ArrayList<EmployeeModel> {
            val list: ArrayList<EmployeeModel> = ArrayList()
            data.forEach { list.add(toModel(it)) }
            return list
        }
    }

    constructor(employeeName: String, employeeSalary: String, employeeAge: String) : this(
        employeeName = employeeName,
        employeeSalary = employeeSalary,
        employeeAge = employeeAge,
        id = null
    )

    fun toMap(): Map<String, Any> {
        return mapOf(
            "name" to employeeName,
            "salary" to employeeSalary,
            "age" to employeeAge
        )
    }
}