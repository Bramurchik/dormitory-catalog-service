package com.kotlinspring.repairs.add_repair

import com.kotlinspring.employees.EmployeesRepository
import com.kotlinspring.repairs.Repair
import com.kotlinspring.repairs.RepairDTO
import com.kotlinspring.rooms.avaiable_rooms.AvailableRoomsRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AddRepairService (
    private val addRepairRepository: AddRepairRepository,
    private val employeesRepository: EmployeesRepository,
    private val availableRoomsRepository: AvailableRoomsRepository,
){
    @Transactional
    fun createRepair(repairDTO: RepairDTO): Long {
        val custodian = employeesRepository.findById(repairDTO.custodianId)
            .orElseThrow { IllegalArgumentException("Custodian with ID ${repairDTO.custodianId} not found") }

        if (custodian.role != "Custodian") {
            throw IllegalArgumentException("Chosen employee is not a custodian")
        }

        val room = availableRoomsRepository.findById(repairDTO.roomId)
            .orElseThrow { IllegalArgumentException("Room with ID ${repairDTO.roomId} not found") }

        val repair = Repair(
            room = room,
            repairType = repairDTO.repairType,
            repairDate = repairDTO.repairDate,
            custodian = custodian,
            cost = repairDTO.cost,
            repairerName = repairDTO.repairerName,
            repairerContact = repairDTO.repairerContact
        )

        return addRepairRepository.save(repair).repairId
    }
}