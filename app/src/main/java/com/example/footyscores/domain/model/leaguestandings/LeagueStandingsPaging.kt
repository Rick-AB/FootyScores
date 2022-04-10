package com.example.footyscores.domain.model.leaguestandings


import com.google.gson.annotations.SerializedName

data class LeagueStandingsPaging(
    @SerializedName("current")
    val current: Int = 0,
    @SerializedName("total")
    val total: Int = 0
)