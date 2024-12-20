package com.kotlinspring.employees

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    val employeeId: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "role")
    val role: String,

    @Column(name = "hire_date")
    val hireDate: LocalDate,

    @Column(name = "contact_phone")
    val contactPhone: String,

    @Column(name = "address")
    val address: String? = null,

    @Column(name = "email")
    val email: String? = null
)
