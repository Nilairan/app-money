package com.helptoyou.core.repository

import com.helptoyou.core.network.Api
import com.helptoyou.domain.model.News
import com.helptoyou.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val api: Api
) : NewsRepository {
    override suspend fun getNews(): List<News> {
        return api.getNews().map { it.map(it) }
    }
}