package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdStatisticX(
    @SerializedName("statistics")
    val statistics: List<FixtureByIdStatisticXX> = listOf(),
    @SerializedName("team")
    val team: FixtureByIdTeamXXX = FixtureByIdTeamXXX()
)