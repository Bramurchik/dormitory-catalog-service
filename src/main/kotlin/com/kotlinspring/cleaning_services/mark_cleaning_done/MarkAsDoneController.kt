package com.kotlinspring.cleaning_services.mark_cleaning_done

import com.kotlinspring.cleaning_services.mark_cleaning_done.MarkAsDoneService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cleaning-services")

class MarkAsDoneController(
    private val markAsDoneService: MarkAsDoneService
) {

    @PutMapping("/{serviceId}/mark-done")
    fun markAsDone(@PathVariable serviceId: Long): ResponseEntity<String> {
        val result = markAsDoneService.markAsDone(serviceId)
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }
}
