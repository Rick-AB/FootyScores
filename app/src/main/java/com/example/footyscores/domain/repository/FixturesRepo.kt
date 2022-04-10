package com.example.footyscores.domain.repository

import com.example.footyscores.data.remote.dto.fixturebydatedto.ResponseBodyDto
import com.example.footyscores.data.remote.dto.fixturebyiddto.FixtureByIdResponseBodyDto
import com.example.footyscores.data.remote.dto.leaguestandings.LeagueStandingsResponseBodyDto

interface FixturesRepo {
    suspend fun getFixturesByDate(date: String): ResponseBodyDto
    suspend fun getFixtureById(id: Int): FixtureByIdResponseBodyDto
    suspend fun getStandingsByLeagueId(season: Int, leagueId: Int): LeagueStandingsResponseBodyDto
}