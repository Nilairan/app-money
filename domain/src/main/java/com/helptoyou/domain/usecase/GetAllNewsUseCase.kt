package com.helptoyou.domain.usecase

import com.helptoyou.domain.model.News
import com.helptoyou.domain.repository.NewsRepository

interface GetAllNewsUseCase {

    suspend operator fun invoke(): List<News>
}

class GetAllNewsUseCaseImpl(
    private val newsRepository: NewsRepository
) : GetAllNewsUseCase {
    override suspend fun invoke(): List<News> {
        return newsRepository.getNews()
    }
}