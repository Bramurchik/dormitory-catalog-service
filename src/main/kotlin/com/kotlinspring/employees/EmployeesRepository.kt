package com.kotlinspring.employees

import org.springframework.data.jpa.repository.JpaRepository

interface EmployeesRepository : JpaRepository<Employee, Long>