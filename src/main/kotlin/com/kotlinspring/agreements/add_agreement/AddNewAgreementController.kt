package com.kotlinspring.agreements.add_agreement

import com.kotlinspring.agreements.AgreementDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/agreements")
class AddNewAgreementController(private val addAgreementService: AddAgreementService) {

    @PostMapping
    fun addAgreement(@RequestBody agreementDTO: AgreementDTO): ResponseEntity<String> {
        addAgreementService.createAgreement(agreementDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body("Agreement created successfully")
    }
}
