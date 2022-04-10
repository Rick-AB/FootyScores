package com.example.footyscores.domain.model.leaguestandings


import com.google.gson.annotations.SerializedName

data class LeagueStandingsLeague(
    @SerializedName("country")
    val country: String = "",
    @SerializedName("flag")
    val flag: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("season")
    val season: Int = 0,
    @SerializedName("standings")
    val standings: List<List<LeagueStandingsStanding>> = listOf()
)