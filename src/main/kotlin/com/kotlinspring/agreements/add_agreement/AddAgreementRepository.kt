package com.kotlinspring.agreements.add_agreement

import com.kotlinspring.agreements.Agreement
import org.springframework.data.jpa.repository.JpaRepository

interface AddAgreementRepository : JpaRepository<Agreement, Long>