package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdPlayerXXX(
    @SerializedName("players")
    val players: List<FixtureByIdPlayerXXXX> = listOf(),
    @SerializedName("team")
    val team: FixtureByIdTeamXX = FixtureByIdTeamXX()
)