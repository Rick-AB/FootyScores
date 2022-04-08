package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdCards(
    @SerializedName("red")
    val red: Int? = 0,
    @SerializedName("yellow")
    val yellow: Int? = 0
)