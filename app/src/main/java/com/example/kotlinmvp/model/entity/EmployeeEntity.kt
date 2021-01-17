package com.example.kotlinmvp.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlinmvp.model.EmployeeModel

@Entity
data class EmployeeEntity(
    @PrimaryKey val id: String,
    val employeeName: String,
    val employeeSalary: String,
    val employeeAge: String
) {
    companion object {
        private fun toEntity(model: EmployeeModel): EmployeeEntity {
            return EmployeeEntity(
                model.id!!,
                model.employeeName,
                model.employeeSalary,
                model.employeeAge
            )
        }

        fun toEntityList(data: ArrayList<EmployeeModel>): ArrayList<EmployeeEntity> {
            val list: ArrayList<EmployeeEntity> = ArrayList()
            data.forEach { list.add(toEntity(it)) }
            return list
        }
    }
}