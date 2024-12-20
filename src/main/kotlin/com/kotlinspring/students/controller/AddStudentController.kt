package com.kotlinspring.students.controller

import com.kotlinspring.dto.StudentDTO
import com.kotlinspring.students.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class StudentController(val studentService: StudentService) {

    @PostMapping
    fun addStudent(@RequestBody studentDTO: StudentDTO): ResponseEntity<String> {
        studentService.addStudent(studentDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body("Student created successfully")
    }
}
