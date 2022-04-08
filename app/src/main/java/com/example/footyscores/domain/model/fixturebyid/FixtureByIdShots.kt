package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdShots(
    @SerializedName("on")
    val on: Int? = 0,
    @SerializedName("total")
    val total: Int? = 0
)