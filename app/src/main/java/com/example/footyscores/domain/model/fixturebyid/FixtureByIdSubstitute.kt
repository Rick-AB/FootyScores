package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdSubstitute(
    @SerializedName("player")
    val player: FixtureByIdPlayerX = FixtureByIdPlayerX()
)