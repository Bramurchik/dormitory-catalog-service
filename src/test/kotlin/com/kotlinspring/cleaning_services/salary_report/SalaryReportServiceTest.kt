package com.kotlinspring.cleaning_services.salary_report

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SalaryReportServiceTest {

    @Autowired
    private lateinit var salaryReportService: SalaryReportService
    private lateinit var salaryReportRepository: SalaryReportRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        salaryReportRepository = mock(SalaryReportRepository::class.java)
        salaryReportService = SalaryReportService(salaryReportRepository)
    }

    @Test
    fun `should return correct salary report`() {
        val mockResponse = listOf(    // Test data
            mapOf(
                "cleanerName" to "John Doe",
                "totalServices" to 10,
                "salaryBeforeTax" to 200.0,
                "tax" to 60.0,
                "salaryAfterTax" to 140.0
            )
        )

        `when`(salaryReportRepository.generateSalaryReport(2024, 12)).thenReturn(mockResponse)

        val result = salaryReportService.salaryReportService(2024, 12) // Service method test call


        assertEquals(1, result.size)
        assertEquals("John Doe", result[0].cleanerName)
        assertEquals(10, result[0].totalServices)
        assertEquals(200.0, result[0].salaryBeforeTax)
        assertEquals(60.0, result[0].tax)
        assertEquals(140.0, result[0].salaryAfterTax)
    }
}
