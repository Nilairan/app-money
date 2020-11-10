package com.helptoyou.core.model

import com.helptoyou.core.common.Mapper
import com.helptoyou.domain.model.News

data class DTONews(
    val title: String,
    val text: String,
    val image_url: String
) : Mapper<DTONews, News> {
    override fun map(value: DTONews): News {
        return News(
            value.title,
            value.text,
            value.image_url
        )
    }
}