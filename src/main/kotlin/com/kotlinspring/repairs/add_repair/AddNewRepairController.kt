package com.kotlinspring.repairs.add_repair

import com.kotlinspring.agreements.add_agreement.AddAgreementService
import com.kotlinspring.repairs.RepairDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/repairs")
class AddNewRepairController(
    private val addRepairService: AddRepairService,
    private val addAgreementService: AddAgreementService
) {

    @PostMapping
    fun addRepair(@RequestBody repairDTO: RepairDTO): ResponseEntity<String> {
        addRepairService.createRepair(repairDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body("Repair created successfully")
    }

}