package com.kotlinspring.agreements

import org.springframework.data.jpa.repository.JpaRepository

interface AgreementRepository : JpaRepository<Agreement, Long>