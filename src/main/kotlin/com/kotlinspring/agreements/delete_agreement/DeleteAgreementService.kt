package com.kotlinspring.agreements.delete_agreement

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteAgreementService(private val deleteAgreementRepository: DeleteAgreementRepository) {

    @Transactional
    fun deleteAgreementById(agreementId: Long) {
        if (!deleteAgreementRepository.existsByAgreementId(agreementId)) {
            throw IllegalArgumentException("Agreement with ID $agreementId does not exist")
        }
        deleteAgreementRepository.deleteById(agreementId)
    }
}
