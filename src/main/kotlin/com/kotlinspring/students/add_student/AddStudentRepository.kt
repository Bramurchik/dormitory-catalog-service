package com.kotlinspring.students.add_student

import com.kotlinspring.students.Student
import org.springframework.data.jpa.repository.JpaRepository


interface AddStudentRepository : JpaRepository<Student, Long>
