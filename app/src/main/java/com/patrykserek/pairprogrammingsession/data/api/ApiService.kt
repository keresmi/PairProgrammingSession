package com.patrykserek.pairprogrammingsession.data.api

import com.patrykserek.pairprogrammingsession.data.api.models.PriceBookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("services")
    suspend fun getPriceBooks(
        @Query("filter.page") currentPage: Int,
        @Query("filter.pageSize") pageSize: Int,
        @Query("serviceTitanApiKey") apiKey: String
    ): PriceBookResponse
}