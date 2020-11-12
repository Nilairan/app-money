package com.helptoyou.domain.model

import java.io.Serializable

data class News(
    val title: String,
    val text: String,
    val imageUrl: String
) : Serializable