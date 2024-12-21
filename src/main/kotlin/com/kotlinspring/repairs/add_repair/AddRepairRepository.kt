package com.kotlinspring.repairs.add_repair

import com.kotlinspring.repairs.Repair
import org.springframework.data.jpa.repository.JpaRepository

interface AddRepairRepository : JpaRepository<Repair, Long>