package com.kotlinspring.cleaning_services.salary_report

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cleaning-services")
class SalaryReportController(val salaryReportService: SalaryReportService) {

    @GetMapping("/salary-report")
    fun getSalaryReport(
        @RequestParam year: Int,
        @RequestParam month: Int
    ) : List<SalaryReportDTO> {
        return salaryReportService.salaryReportService(year, month)
    }
}