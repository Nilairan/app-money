package com.helptoyou.domain.usecase

import com.helptoyou.domain.model.Credit
import com.helptoyou.domain.repository.CreditsRepository

interface GetCreditsUseCase {
    suspend operator fun invoke(): List<Credit>
}

class GetCreditsUseCaseImpl(
    private val creditsRepository: CreditsRepository
) : GetCreditsUseCase {

    override suspend fun invoke(): List<Credit> {
        return creditsRepository.fetchCredits()
    }

}