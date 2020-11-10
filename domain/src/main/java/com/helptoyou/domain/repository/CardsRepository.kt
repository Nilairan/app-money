package com.helptoyou.domain.repository

import com.helptoyou.domain.model.Card

interface CardsRepository {
    suspend fun getCardsRepository(): List<Card>
}