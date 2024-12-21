package com.kotlinspring.agreements.delete_agreement

import com.kotlinspring.agreements.Agreement
import org.springframework.data.jpa.repository.JpaRepository

interface DeleteAgreementRepository : JpaRepository<Agreement, Long> {
    fun existsByAgreementId(agreementId: Long): Boolean
}
