package com.example.footyscores.presentation.fixture_details

import com.example.footyscores.domain.model.fixturebyid.FixtureByIdResponse
import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsResponse

data class FixtureDetailsState(
    val error: String? = null,
    val loading: Boolean = false,
    val isRefreshing: Boolean = false,
    val fixtureDetails: FixtureByIdResponse? = null,
    val leagueStandings: LeagueStandingsResponse? = null
)
