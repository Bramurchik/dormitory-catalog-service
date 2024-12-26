package com.kotlinspring.cleaning_services.mark_cleaning_done

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class MarkAsDoneService(
    private val markAsDoneRepository: MarkAsDoneRepository
) {
    @Transactional
    fun markAsDone(serviceId: Long): String {
        val cleaningService = markAsDoneRepository.findById(serviceId)
            .orElseThrow { IllegalArgumentException("CleaningService with ID $serviceId not found") }

        if (cleaningService.done) {
            return "CleaningService with ID $serviceId is already marked as done"
        }

        cleaningService.done = true
        markAsDoneRepository.save(cleaningService)
        return "CleaningService with ID $serviceId marked as done successfully"
    }
}
