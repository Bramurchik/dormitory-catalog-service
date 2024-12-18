package com.kotlinspring

    data class SalaryReportDTO(
        val cleanerName: String,
        val totalServices: Int,
        val salaryBeforeTax: Double,
        val tax: Double,
        val salaryAfterTax: Double
    )
