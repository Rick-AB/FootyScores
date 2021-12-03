package com.example.footyscores.data.remote

import com.example.footyscores.data.remote.dto.ResponseDataDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiFootball {

    @GET("fixtures")
    suspend fun getFixturesByDate(
        @Query("date") date: String
    ): ResponseDataDto
}