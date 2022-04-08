package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdTeams(
    @SerializedName("away")
    val away: FixtureByIdAway = FixtureByIdAway(),
    @SerializedName("home")
    val home: FixtureByIdHome = FixtureByIdHome()
)