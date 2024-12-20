package com.kotlinspring.students

import com.kotlinspring.dto.StudentDTO
import org.springframework.stereotype.Service

@Service
class StudentService(val studentRepository: StudentRepository) {

    fun addStudent(studentDTO: StudentDTO): Long {
        val student = Student(
            name = studentDTO.name,
            surname = studentDTO.surname,
            dob = studentDTO.dob,
            sex = studentDTO.sex,
            phoneNumber = studentDTO.phoneNumber,
            country = studentDTO.country
        )
        return studentRepository.save(student).studentId
    }
}
