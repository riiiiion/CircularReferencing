package com.example.demo.entity
import jakarta.persistence.*

@Entity
@Table(name = "departments")
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var name: String,

    @OneToMany(mappedBy = "department",cascade=[CascadeType.ALL], fetch = FetchType.EAGER)
    val employees: MutableList<Employee> = mutableListOf()
)