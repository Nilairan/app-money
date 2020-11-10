package com.helptoyou.domain.usecase

import com.helptoyou.domain.model.PrivacyPolicy
import com.helptoyou.domain.repository.PrivacyRepository

interface GetPrivacyPolicyUseCase {
    suspend operator fun invoke(): PrivacyPolicy
}

class GetPrivacyPolicyUseCaseImpl(
    private val privacyRepository: PrivacyRepository
) : GetPrivacyPolicyUseCase {
    override suspend fun invoke(): PrivacyPolicy {
        return privacyRepository.getPrivacyPolicy()
    }
}