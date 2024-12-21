package com.kotlinspring.rooms.avaiable_rooms

import com.kotlinspring.rooms.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AvailableRoomsRepository : JpaRepository<Room, Long> {
    @Query(
        """
        SELECT r FROM Room r
        LEFT JOIN Agreement a ON r.roomId = a.room.roomId AND a.endDate > CURRENT_DATE
        WHERE a.agreementId IS NULL
        """
    ) fun findAllAvailableRooms(): List<Room>
}