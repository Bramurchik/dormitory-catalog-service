package com.kotlinspring.students
import java.time.LocalDate

data class StudentDTO(
    val name: String,
    val surname: String,
    val dob: LocalDate,
    val sex: String,
    val phoneNumber: String?,
    val country: String?
)
