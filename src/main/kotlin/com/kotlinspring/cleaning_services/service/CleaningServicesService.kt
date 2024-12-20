package com.kotlinspring.cleaning_services.service

import com.kotlinspring.dtos.SalaryReportDTO
import com.kotlinspring.cleaning_services.repository.CleaningServicesRepository
import org.springframework.stereotype.Service


@Service
class CleaningServicesService(
    private val cleaningServicesRepository: CleaningServicesRepository
) {

    fun salaryReportService(year: Int, month: Int): List<SalaryReportDTO> {
        val result = cleaningServicesRepository.generateSalaryReport(year, month)
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
