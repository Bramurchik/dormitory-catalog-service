package com.kotlinspring.rooms.service

import com.kotlinspring.rooms.repository.RoomRepository
import com.kotlinspring.rooms.Room
import org.springframework.stereotype.Service

@Service
class RoomService (private val RoomRepository: RoomRepository) {
    fun availableRoomsService(): List<Room> {
        return RoomRepository.findAllAvailableRooms()
    }
}