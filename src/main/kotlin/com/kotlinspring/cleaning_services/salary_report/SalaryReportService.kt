package com.kotlinspring.cleaning_services.salary_report

import org.springframework.stereotype.Service


@Service
class SalaryReportService(
    private val salaryReportRepository: SalaryReportRepository
) {

    fun salaryReportService(year: Int, month: Int): List<SalaryReportDTO> {
        val result = salaryReportRepository.generateSalaryReport(year, month)
        return result.map {      // Manual assignation of DTO due to usage of native SQL
            SalaryReportDTO(
                cleanerName = it["cleanerName"] as String,
                totalServices = (it["totalServices"] as Number).toInt(),
                salaryBeforeTax = (it["salaryBeforeTax"] as Number).toDouble(),
                tax = (it["tax"] as Number).toDouble(),
                salaryAfterTax = (it["salaryAfterTax"] as Number).toDouble()
            )
        }
    }
}
