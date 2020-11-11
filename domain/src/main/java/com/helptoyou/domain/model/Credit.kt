package com.helptoyou.domain.model

import java.io.Serializable

data class Credit(
        val imageUrl: String,
        val name: String,
        val rating: Double,
        val age: String,
        val percent: String,
        val sumOne: String,
        val sumMin: String,
        val daysInfo: String,
        val termTo: String,
        val url: String,
        val email: String,
        val address: String,
        val workTime: String,
        val license: String,
        val scorost: String,
        val dokuments: String,
        val sposob: String,
        val nalichnie: Boolean,
        val nakartu: Boolean,
        val zafiveminut: Boolean,
        val kruglosutochno: Boolean
) : Serializable