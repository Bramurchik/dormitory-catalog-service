package com.kotlinspring.model

import jakarta.persistence.*
import java.io.Serializable

@Embeddable
data class WorkingId(
    val blockNumber: Long,
    val employeeId: Long
) : Serializable

@Entity
@Table(name = "working")
data class Working(
    @EmbeddedId
    val id: WorkingId,

    @ManyToOne
    @MapsId("blockNumber")
    @JoinColumn(name = "block_number")
    val block: Block,

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    val employee: Employee
)
