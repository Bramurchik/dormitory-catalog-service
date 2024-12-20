package com.kotlinspring.cleaning_services.controller

import com.kotlinspring.dto.SalaryReportDTO
import com.kotlinspring.cleaning_services.CleaningServicesService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cleaning-services")
class SalaryReportController(val cleaningServicesService: CleaningServicesService) {

    @GetMapping("/salary-report")
    fun getSalaryReport(
        @RequestParam year: Int,
        @RequestParam month: Int
    ) : List<SalaryReportDTO> {
        return cleaningServicesService.salaryReportService(year, month)
    }
}