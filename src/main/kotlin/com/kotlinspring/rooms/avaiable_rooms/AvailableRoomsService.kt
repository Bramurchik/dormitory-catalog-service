package com.kotlinspring.rooms.avaiable_rooms

import com.kotlinspring.rooms.Room
import org.springframework.stereotype.Service

@Service
class AvailableRoomsService (private val AvailableRoomsRepository: AvailableRoomsRepository) {
    fun availableRoomsService(): List<Room> {
        return AvailableRoomsRepository.findAllAvailableRooms()
    }
}