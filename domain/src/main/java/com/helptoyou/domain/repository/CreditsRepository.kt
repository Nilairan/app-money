package com.helptoyou.domain.repository

import com.helptoyou.domain.model.Credit

interface CreditsRepository {
    suspend fun fetchCredits(): List<Credit>
}