package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdDuels(
    @SerializedName("total")
    val total: Int? = 0,
    @SerializedName("won")
    val won: Int? = 0
)