package com.kotlinspring.students.add_student

import com.kotlinspring.students.Student
import com.kotlinspring.students.StudentDTO
import org.springframework.stereotype.Service

@Service
class AddStudentService(val addStudentRepository: AddStudentRepository) {

    fun addStudent(studentDTO: StudentDTO): Long {
        val student = Student(
            name = studentDTO.name,
            surname = studentDTO.surname,
            dob = studentDTO.dob,
            sex = studentDTO.sex,
            phoneNumber = studentDTO.phoneNumber,
            country = studentDTO.country
        )
        return addStudentRepository.save(student).studentId
    }
}
