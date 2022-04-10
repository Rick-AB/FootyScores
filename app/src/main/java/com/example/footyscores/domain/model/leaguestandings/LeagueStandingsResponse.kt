package com.example.footyscores.domain.model.leaguestandings


import com.google.gson.annotations.SerializedName

data class LeagueStandingsResponse(
    @SerializedName("league")
    val league: LeagueStandingsLeague = LeagueStandingsLeague()
)