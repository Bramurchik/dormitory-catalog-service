package com.kotlinspring.repairs

import java.time.LocalDate

data class RepairDTO (
    val roomId: Long,
    val repairType: String,
    val repairDate: LocalDate,
    val custodianId : Long,
    val cost : Double?,
    val repairerName: String? = null,
    val repairerContact: String? = null,
)