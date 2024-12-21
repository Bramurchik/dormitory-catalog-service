package com.kotlinspring.students.add_student

import com.kotlinspring.students.StudentDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class AddStudentController(val addStudentService: AddStudentService) {

    @PostMapping
    fun addStudent(@RequestBody studentDTO: StudentDTO): ResponseEntity<String> {
        addStudentService.addStudent(studentDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body("Student created successfully")
    }
}
