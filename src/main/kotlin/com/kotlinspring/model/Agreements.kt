package com.kotlinspring.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "agreements")
data class Agreement(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agreement_id")
    val agreementId: Long = 0,

    @ManyToOne
    @JoinColumn(name = "room_id")
    val room: Room,

    @ManyToOne
    @JoinColumn(name = "student_id")
    val student: Student,

    @ManyToOne
    @JoinColumn(name = "custodian_id")
    val custodian: Employee,

    @Column(name = "start_date")
    val startDate: LocalDate,

    @Column(name = "end_date")
    val endDate: LocalDate,

    @Column(name = "date_time_signed")
    val dateTimeSigned: LocalDateTime,

    @Column(name = "monthly_payment")
    val monthlyPayment: Double
)
