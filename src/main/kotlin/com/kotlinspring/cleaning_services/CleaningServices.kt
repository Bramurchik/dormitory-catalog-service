package com.kotlinspring.cleaning_services

import com.kotlinspring.employees.Employee
import com.kotlinspring.rooms.Room
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "Cleaning_Services")
data class CleaningService(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    val serviceId: Long = 0,

    @Column(name = "service_type")
    val serviceType: String,

    @ManyToOne
    @JoinColumn(name = "room_id")
    val room: Room,

    @Column(name = "request_date")
    val requestDate: LocalDate,

    @Column(name = "done")
    var done: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "cleaning_person_id")
    val cleaningPerson: Employee,

    @ManyToOne
    @JoinColumn(name = "custodian_id")
    val custodian: Employee
)
