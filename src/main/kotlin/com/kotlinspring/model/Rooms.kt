package com.kotlinspring.model

import jakarta.persistence.*

@Entity
@Table(name = "rooms")
data class Room(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    val roomId: Long = 0,

    @Column(name = "room_number")
    val roomNumber: Int,

    @ManyToOne
    @JoinColumn(name = "block_number")
    val block: Block
)
