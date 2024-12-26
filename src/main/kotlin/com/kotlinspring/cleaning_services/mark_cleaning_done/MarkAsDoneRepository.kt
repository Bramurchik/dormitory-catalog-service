package com.kotlinspring.cleaning_services.mark_cleaning_done

import com.kotlinspring.cleaning_services.CleaningService
import org.springframework.data.jpa.repository.JpaRepository

interface MarkAsDoneRepository : JpaRepository<CleaningService, Long>
