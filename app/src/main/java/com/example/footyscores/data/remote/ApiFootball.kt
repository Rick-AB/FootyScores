package com.example.footyscores.data.remote

import com.example.footyscores.data.remote.dto.fixturebydatedto.ResponseBodyDto
import com.example.footyscores.data.remote.dto.fixturebyiddto.FixtureByIdResponseBodyDto
import com.example.footyscores.data.remote.dto.leaguestandings.LeagueStandingsResponseBodyDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiFootball {

    @GET("fixtures")
    suspend fun getFixturesByDate(
        @Query("date") date: String
    ): ResponseBodyDto

    @GET("fixtures")
    suspend fun getFixtureById(
        @Query("id") id: Int
    ): FixtureByIdResponseBodyDto

    @GET("standings")
    suspend fun getStaindingsByLeagueId(
        @Query("season") season: Int,
        @Query("league") leagueId: Int
    ): LeagueStandingsResponseBodyDto
}