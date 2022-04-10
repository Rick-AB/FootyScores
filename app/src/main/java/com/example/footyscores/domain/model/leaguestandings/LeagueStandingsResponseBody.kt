package com.example.footyscores.domain.model.leaguestandings


import com.google.gson.annotations.SerializedName

data class LeagueStandingsResponseBody(
    @SerializedName("errors")
    val errors: List<Any> = listOf(),
    @SerializedName("get")
    val `get`: String = "",
    @SerializedName("paging")
    val paging: LeagueStandingsPaging = LeagueStandingsPaging(),
    @SerializedName("parameters")
    val parameters: LeagueStandingsParameters = LeagueStandingsParameters(),
    @SerializedName("response")
    val response: List<LeagueStandingsResponse> = listOf(),
    @SerializedName("results")
    val results: Int = 0
)