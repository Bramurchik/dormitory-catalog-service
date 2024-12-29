package com.kotlinspring.cleaning_services.salary_report

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(SalaryReportController::class)
class SalaryReportControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc // HTTP requests imitatot

    @MockBean
    private lateinit var salaryReportService: SalaryReportService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `should return salary report`() {
        val mockResponse = listOf(      // Test data
            SalaryReportDTO(
                cleanerName = "John Doe",
                totalServices = 10,
                salaryBeforeTax = 200.0,
                tax = 60.0,
                salaryAfterTax = 140.0
            )
        )

        `when`(salaryReportService.salaryReportService(2024, 12)).thenReturn(mockResponse)

        val result = mockMvc.perform(   // HTTP request imitation
            get("/cleaning-services/salary-report")
                .param("year", "2024")
                .param("month", "12")
        )
            .andExpect(status().isOk)  // Return status should be 200
            .andReturn()

        val content = result.response.contentAsString
        assertTrue(content.contains("John Doe"))
    }
}
