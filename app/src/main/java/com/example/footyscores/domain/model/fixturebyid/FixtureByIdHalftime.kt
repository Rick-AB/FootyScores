package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdHalftime(
    @SerializedName("away")
    val away: Int? = 0,
    @SerializedName("home")
    val home: Int? = 0
)