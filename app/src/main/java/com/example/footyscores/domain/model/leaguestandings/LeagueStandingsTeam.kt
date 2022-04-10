package com.example.footyscores.domain.model.leaguestandings


import com.google.gson.annotations.SerializedName

data class LeagueStandingsTeam(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = ""
)