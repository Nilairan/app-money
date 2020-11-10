package com.helptoyou.core.model

import com.helptoyou.core.common.Mapper
import com.helptoyou.domain.model.Credit

data class DTOCredit(
    val image_url: String,
    val name: String,
    val rating: Double,
    val age: String,
    val percent: String,
    val sum_one: String,
    val sum_min: String,
    val days_info: String,
    val term_to: String,
    val url: String,
    val email: String,
    val address: String,
    val work_time: String,
    val license: String,
    val scorost: String,
    val dokuments: String,
    val sposob: String,
    val nalichnie: Boolean,
    val nakartu: Boolean,
    val zafiveminut: Boolean,
    val kruglosutochno: Boolean
) : Mapper<DTOCredit, Credit> {

    override fun map(value: DTOCredit): Credit {
        return Credit(
            value.image_url,
            value.name,
            value.rating,
            value.age,
            value.percent,
            value.sum_one,
            value.sum_min,
            value.days_info,
            value.term_to,
            value.url,
            value.email,
            value.address,
            value.work_time,
            value.license,
            value.scorost,
            value.dokuments,
            value.sposob,
            value.nalichnie,
            value.nakartu,
            value.zafiveminut,
            value.kruglosutochno
        )
    }
}