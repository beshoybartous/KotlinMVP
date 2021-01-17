package com.example.kotlinmvp.cache.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlinmvp.model.entity.EmployeeEntity

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM EmployeeEntity")
    suspend fun getAll(): List<EmployeeEntity>

    @Insert
    suspend fun insertAll(employeeEntityList: List<EmployeeEntity>)

    @Delete
    suspend fun delete(employeeEntity: EmployeeEntity)
}