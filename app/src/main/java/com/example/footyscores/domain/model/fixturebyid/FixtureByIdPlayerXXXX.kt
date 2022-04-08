package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdPlayerXXXX(
    @SerializedName("player")
    val player: FixtureByIdPlayerXXXXX = FixtureByIdPlayerXXXXX(),
    @SerializedName("statistics")
    val statistics: List<FixtureByIdStatistic> = listOf()
)