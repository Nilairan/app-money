package com.helptoyou.core.repository

import com.helptoyou.core.network.Api
import com.helptoyou.domain.model.Credit
import com.helptoyou.domain.repository.CreditsRepository

class CreditsRepositoryImpl(
    private val api: Api
) : CreditsRepository {
    override suspend fun fetchCredits(): List<Credit> {
        return api.getZaim().map { it.map(it) }
    }
}