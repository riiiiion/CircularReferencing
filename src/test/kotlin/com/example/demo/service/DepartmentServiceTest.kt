package com.example.demo.service

import com.example.demo.entity.Department
import com.example.demo.entity.Employee
import com.example.demo.repository.DepartmentRepository
import com.example.demo.repository.EmployeeRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private lateinit var departmentService: DepartmentService

    @Autowired
    private lateinit var departmentRepository: DepartmentRepository

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    @Test
    fun `全件取得する`(){

        // データの仕込み
        val departmentRecord1 = Department(
            name = "開発部"
        )
        val employee1 = Employee(
            name = "nami",
            department = departmentRecord1
        )
        val employee2 = Employee(
            name = "suga",
            department = departmentRecord1
        )
        val employee3 = Employee(
            name = "suganami",
            department = departmentRecord1
        )

        val departmentRecord2 = Department(
            name = "人事部"
        )
        val employee4 = Employee(
            name = "nami2",
            department = departmentRecord2
        )
        val employee5 = Employee(
            name = "suga2",
            department = departmentRecord2
        )
        val employee6 = Employee(
            name = "suganami2",
            department = departmentRecord2
        )

        departmentRecord1.employees.addAll(listOf(employee1,employee2,employee3))
        departmentRecord2.employees.addAll(listOf(employee4,employee5,employee6))

        // データの保存処理
        departmentRepository.saveAll(
            listOf(
                departmentRecord1,
                departmentRecord2
            )
        )

        // データの取得
        val result = departmentService.getAllDepartment()

        //ここでstackOverFlowのエラーが発生
        println(result)
    }

}