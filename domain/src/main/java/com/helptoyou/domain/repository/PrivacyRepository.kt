package com.helptoyou.domain.repository

import com.helptoyou.domain.model.PrivacyPolicy

interface PrivacyRepository {
    suspend fun getPrivacyPolicy(): PrivacyPolicy
}