package com.kotlinspring.agreements

import java.time.LocalDate

data class AgreementDTO(
    val roomId: Long,
    val studentId: Long,
    val custodianId: Long,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val monthlyPayment: Double
)
