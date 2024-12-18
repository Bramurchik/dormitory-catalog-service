package com.kotlinspring.controller

import com.kotlinspring.model.Room
import com.kotlinspring.repository.RoomRepository
import com.kotlinspring.service.RoomService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/rooms")
class RoomController(val roomService: RoomService) {

    @GetMapping("/available")
    fun listAvailableRooms(): List<Room> {
        return roomService.availableRoomsService()
    }
}

