package com.kotlinspring.repairs

import com.kotlinspring.employees.Employee
import com.kotlinspring.rooms.Room
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "repairs")
data class Repair(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_id")
    val repairId: Long = 0,

    @Column(name = "repair_type")
    val repairType: String,

    @Column(name = "repair_date")
    val repairDate: LocalDate,

    @Column(name = "cost")
    val cost: Double? = null,

    @Column(name = "repairer_name")
    val repairerName: String? = null,

    @Column(name = "repairer_contact")
    val repairerContact: String? = null,

    @ManyToOne
    @JoinColumn(name = "room_id")
    val room: Room,

    @ManyToOne
    @JoinColumn(name = "custodian_id")
    val custodian: Employee
)
