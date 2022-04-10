package com.example.footyscores.domain.model.leaguestandings


import com.google.gson.annotations.SerializedName

data class LeagueStandingsHome(
    @SerializedName("draw")
    val draw: Int = 0,
    @SerializedName("goals")
    val goals: LeagueStandingsGoals = LeagueStandingsGoals(),
    @SerializedName("lose")
    val lose: Int = 0,
    @SerializedName("played")
    val played: Int = 0,
    @SerializedName("win")
    val win: Int = 0
)