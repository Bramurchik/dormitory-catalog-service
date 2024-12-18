package com.kotlinspring.repository

import com.kotlinspring.model.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface RoomRepository : JpaRepository<Room, Long> {
    @Query(
        """
        SELECT r FROM Room r
        LEFT JOIN Agreement a ON r.roomId = a.room.roomId AND a.endDate > CURRENT_DATE
        WHERE a.agreementId IS NULL
        """
    ) fun findAllAvailableRooms(): List<Room>
}