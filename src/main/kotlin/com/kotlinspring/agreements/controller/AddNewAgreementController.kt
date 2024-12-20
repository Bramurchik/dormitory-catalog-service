package com.kotlinspring.agreements.controller

import com.kotlinspring.agreements.AgreementService
import com.kotlinspring.dto.AgreementDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/agreements")
class AddNewAgreementController(private val agreementService: AgreementService) {

    @PostMapping
    fun addAgreement(@RequestBody agreementDTO: AgreementDTO): ResponseEntity<String> {
        agreementService.createAgreement(agreementDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body("Agreement created successfully")
    }
}
