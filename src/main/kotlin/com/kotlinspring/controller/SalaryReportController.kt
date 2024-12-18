package com.kotlinspring.controller

import com.kotlinspring.SalaryReportDTO
import com.kotlinspring.service.CleaningServicesService
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