package com.helptoyou.core.repository

import com.helptoyou.core.network.Api
import com.helptoyou.domain.model.PrivacyPolicy
import com.helptoyou.domain.repository.PrivacyRepository

class PrivacyRepositoryImpl(
    private val api: Api
) : PrivacyRepository {
    override suspend fun getPrivacyPolicy(): PrivacyPolicy {
        return api.getPrivacy()
    }
}