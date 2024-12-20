package com.kotlinspring.rooms

import org.springframework.stereotype.Service

@Service
class RoomService (private val RoomRepository: RoomRepository) {
    fun availableRoomsService(): List<Room> {
        return RoomRepository.findAllAvailableRooms()
    }
}