package com.example.demo.entity

import jakarta.persistence.*

@Entity
@Table(name = "employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var name: String ="",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    var department: Department
){

    //ここでtoStringメソッドをoverrideすることで循環参照によるstackOverFlowを防止
    //以下をコメントアウトするとエラーになります
    override fun toString(): String {
        return "Employee(" +
                "id = $id, " +
                "name = $name, " +
                "department = Department(" +
                "id = ${department.id} "+
                "name = ${department.name}" +
                "employee = 循環参照の為省略"+
        ")"
    }
}