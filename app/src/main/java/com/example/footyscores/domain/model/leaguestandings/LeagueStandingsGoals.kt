package com.example.footyscores.domain.model.leaguestandings


import com.google.gson.annotations.SerializedName

data class LeagueStandingsGoals(
    @SerializedName("against")
    val against: Int = 0,
    @SerializedName("for")
    val forX: Int = 0
)