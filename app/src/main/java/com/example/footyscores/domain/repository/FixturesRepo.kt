package com.example.footyscores.domain.repository

import com.example.footyscores.common.Resource
import com.example.footyscores.data.remote.dto.fixturebyiddto.FixtureByIdResponseBodyDto
import com.example.footyscores.data.remote.dto.leaguestandings.LeagueStandingsResponseBodyDto
import com.example.footyscores.domain.model.fixturebydate.Response
import kotlinx.coroutines.flow.Flow

interface FixturesRepo {
    suspend fun getFixturesByDate(
        date: String,
        fetchFromNetwork: Boolean
    ): Flow<Resource<List<Response>>>

    suspend fun getFixtureById(id: Int): FixtureByIdResponseBodyDto
    suspend fun getStandingsByLeagueId(season: Int, leagueId: Int): LeagueStandingsResponseBodyDto
    suspend fun updateFixtureFavoriteStatus(fixtureId: Int, favoriteStatus: Boolean)
}