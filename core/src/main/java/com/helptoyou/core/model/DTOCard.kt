package com.helptoyou.core.model

import com.helptoyou.core.common.Mapper
import com.helptoyou.domain.model.Card

data class DTOCard(
    val name: String,
    val price_info: String,
    val image_url: String,
    val sum: String,
    val term: String,
    val percent: String,
    val url: String,
    val text: String
) : Mapper<DTOCard, Card> {
    override fun map(value: DTOCard): Card {
        return Card(
            value.name,
            value.price_info,
            value.image_url,
            value.sum,
            value.term,
            value.percent,
            value.url,
            value.text
        )
    }
}