package com.kotlinspring.students

import org.springframework.data.jpa.repository.JpaRepository


interface StudentRepository : JpaRepository<Student, Long>
