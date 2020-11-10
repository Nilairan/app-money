package com.helptoyou.core.network

import com.helptoyou.core.model.DTOCard
import com.helptoyou.core.model.DTOCredit
import com.helptoyou.core.model.DTONews
import com.helptoyou.domain.model.PrivacyPolicy
import retrofit2.http.GET

interface Api {

    @GET("zaim.json")
    suspend fun getZaim(): List<DTOCredit>

    @GET("kard.json")
    suspend fun getCards(): List<DTOCard>

    @GET("news.json")
    suspend fun getNews(): List<DTONews>

    @GET("politika-confidens.json")
    suspend fun getPrivacy(): PrivacyPolicy

}