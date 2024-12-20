package com.kotlinspring.rooms

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RoomRepository : JpaRepository<Room, Long> {
    @Query(
        """
        SELECT r FROM Room r
        LEFT JOIN Agreement a ON r.roomId = a.room.roomId AND a.endDate > CURRENT_DATE
        WHERE a.agreementId IS NULL
        """
    ) fun findAllAvailableRooms(): List<Room>
}