package com.example.demo.service

import com.example.demo.entity.Department
import com.example.demo.repository.DepartmentRepository
import org.springframework.stereotype.Service

interface DefaultDepartmentService{
    fun getAllDepartment():List<Department>
}

@Service
class DepartmentService(
   val  departmentRepository: DepartmentRepository
):DefaultDepartmentService {
    override fun getAllDepartment(): List<Department> {
        return departmentRepository.findAll()
    }
}