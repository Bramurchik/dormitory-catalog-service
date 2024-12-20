package com.kotlinspring.agreements

import com.kotlinspring.dto.AgreementDTO
import com.kotlinspring.employees.EmployeesRepository
import com.kotlinspring.rooms.RoomRepository
import com.kotlinspring.students.StudentRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AgreementService(
    private val agreementRepository: AgreementRepository,
    private val studentRepository: StudentRepository,
    private val roomRepository: RoomRepository,
    private val employeeRepository: EmployeesRepository
) {
    @Transactional
    fun createAgreement(agreementDTO: AgreementDTO): Long {
        val student = studentRepository.findById(agreementDTO.studentId)
            .orElseThrow { IllegalArgumentException("Student with ID ${agreementDTO.studentId} not found") }

        val room = roomRepository.findById(agreementDTO.roomId)
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
        return agreementRepository.save(agreement).agreementId
    }
}
