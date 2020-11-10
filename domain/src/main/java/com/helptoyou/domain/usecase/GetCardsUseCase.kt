package com.helptoyou.domain.usecase

import com.helptoyou.domain.model.Card
import com.helptoyou.domain.repository.CardsRepository

interface GetCardsUseCase {
    suspend operator fun invoke(): List<Card>
}

class GetCardsUseCaseImpl(
    private val cardsRepository: CardsRepository
) : GetCardsUseCase {
    override suspend fun invoke(): List<Card> {
        return cardsRepository.getCardsRepository()
    }
}