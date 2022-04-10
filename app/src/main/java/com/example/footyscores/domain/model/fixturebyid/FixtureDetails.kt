package com.example.footyscores.domain.model.fixturebyid

import com.example.footyscores.common.Resource
import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsResponse

data class FixtureDetails(
    val fixtureByIdResponse: Resource<FixtureByIdResponse>? = null,
    val leagueStandingsByLeagueIdResponse: Resource<LeagueStandingsResponse>? = null
)
