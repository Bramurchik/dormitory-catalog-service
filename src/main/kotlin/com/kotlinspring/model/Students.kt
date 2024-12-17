package com.kotlinspring.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "students")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    val studentId: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "surname")
    val surname: String,

    @Column(name = "dob")
    val dob: LocalDate,

    @Column(name = "sex")
    val sex: String,

    @Column(name = "phone_number")
    val phoneNumber: String? = null,

    @Column(name = "country_of_origin")
    val country: String? = null
)
