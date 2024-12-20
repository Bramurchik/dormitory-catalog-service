package com.kotlinspring.dtos

    data class SalaryReportDTO(        // DTO for storing the result of a query
        val cleanerName: String,
        val totalServices: Int,
        val salaryBeforeTax: Double,
        val tax: Double,
        val salaryAfterTax: Double
    )
