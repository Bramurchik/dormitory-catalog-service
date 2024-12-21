package com.kotlinspring.rooms.avaiable_rooms

import com.kotlinspring.rooms.Room
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/rooms")
class AvailableRoomsController(val availableRoomsService: AvailableRoomsService) {

    @GetMapping("/available")
    fun listAvailableRooms(): List<Room> {
        return availableRoomsService.availableRoomsService()
    }
}

