package com.kotlinspring.blocks

import jakarta.persistence.*

@Entity
@Table(name = "blocks")
data class Block(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_number")
    val id: Long = 0,

    @Column(name = "type_of_block")
    val type: String,

    @Column(name = "number_of_floors")
    val numberOfFloors: Int
)
