package com.example.footyscores.domain.model.leaguestandings


import com.google.gson.annotations.SerializedName

data class LeagueStandingsParameters(
    @SerializedName("league")
    val league: String = "",
    @SerializedName("season")
    val season: String = ""
)