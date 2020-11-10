package com.helptoyou.domain.repository

import com.helptoyou.domain.model.News

interface NewsRepository {
    suspend fun getNews(): List<News>
}