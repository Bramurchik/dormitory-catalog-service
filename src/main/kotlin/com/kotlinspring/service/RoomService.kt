package com.kotlinspring.service

import com.kotlinspring.model.Room
import com.kotlinspring.repository.RoomRepository
import org.springframework.stereotype.Service

@Service
class RoomService (private val RoomRepository: RoomRepository) {
    fun availableRoomsService(): List<Room> {
        return RoomRepository.findAllAvailableRooms()
    }
}