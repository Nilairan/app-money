package com.helptoyou.core.repository

import com.helptoyou.core.network.Api
import com.helptoyou.domain.model.Card
import com.helptoyou.domain.repository.CardsRepository

class CardsRepositoryImpl(
    private val api: Api
) : CardsRepository {
    override suspend fun getCardsRepository(): List<Card> {
        return api.getCards().map { it.map(it) }
    }
}