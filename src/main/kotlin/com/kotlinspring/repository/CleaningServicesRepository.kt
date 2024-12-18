package com.kotlinspring.repository

import com.kotlinspring.model.CleaningService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CleaningServicesRepository : JpaRepository<CleaningService, Long> {
    @Query(
        """
        SELECT 
            e.name AS cleanerName,
            COUNT(cs.service_id) AS totalServices,
            COUNT(cs.service_id) * 20.00 AS salaryBeforeTax,
            COUNT(cs.service_id) * 20.00 * 0.30 AS tax,
            COUNT(cs.service_id) * 20.00 * 0.70 AS salaryAfterTax
        FROM cleaning_services cs
        JOIN employees e ON cs.cleaning_person_id = e.employee_id
        WHERE e.role = 'Cleaning Staff'
        AND EXTRACT(YEAR FROM cs.request_date) = :yearInput --- Separating the year and month values for further comparison 
        AND EXTRACT(MONTH FROM cs.request_date) = :monthInput
        GROUP BY e.name
    """,
        nativeQuery = true // Native SQL is being used due for EXTRACT function
    )
    fun generateSalaryReport(
        @Param("yearInput") yearInput: Int,  // binding of the value passed in the request to the function parameter.
        @Param("monthInput") monthInput: Int
    ): List<Map<String, Any>>  // Returns a map of needed parameters for furthermore transformation into DTO


}
