package com.kotlinspring.agreements.delete_agreement

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/agreements")
class DeleteAgreementController(private val deleteAgreementService: DeleteAgreementService) {

    @DeleteMapping("/{id}")
    fun deleteAgreement(@PathVariable id: Long): ResponseEntity<String> {
        deleteAgreementService.deleteAgreementById(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Agreement with ID $id deleted successfully")
    }
}
