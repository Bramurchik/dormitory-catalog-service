package com.kotlinspring.agreements.add_agreement

import com.kotlinspring.agreements.Agreement
import com.kotlinspring.agreements.AgreementDTO
import com.kotlinspring.employees.EmployeesRepository
import com.kotlinspring.rooms.avaiable_rooms.AvailableRoomsRepository
import com.kotlinspring.students.add_student.AddStudentRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AddAgreementService(
    private val addAgreementRepository: AddAgreementRepository,
    private val addStudentRepository: AddStudentRepository,
    private val availableRoomsRepository: AvailableRoomsRepository,
    private val employeeRepository: EmployeesRepository
) {
    @Transactional
    fun createAgreement(agreementDTO: AgreementDTO): Long {
        val student = addStudentRepository.findById(agreementDTO.studentId)
            .orElseThrow { IllegalArgumentException("Student with ID ${agreementDTO.studentId} not found") }

        val room = availableRoomsRepository.findById(agreementDTO.roomId)
            .orElseThrow { IllegalArgumentException("Room with ID ${agreementDTO.roomId} not found") }

        val custodian = employeeRepository.findById(agreementDTO.custodianId)
            .orElseThrow { IllegalArgumentException("Custodian with ID ${agreementDTO.custodianId} not found") }

        if (custodian.role != "Custodian") {
            throw IllegalArgumentException("Chosen employee is not a custodian")
        }

        val agreement = Agreement(
            student = student,
            room = room,
            startDate = agreementDTO.startDate,
            endDate = agreementDTO.endDate,
            custodian = custodian,
            monthlyPayment = agreementDTO.monthlyPayment,
            agreementId = 0,
            dateTimeSigned = LocalDateTime.now(),
        )
        return addAgreementRepository.save(agreement).agreementId
    }
}
