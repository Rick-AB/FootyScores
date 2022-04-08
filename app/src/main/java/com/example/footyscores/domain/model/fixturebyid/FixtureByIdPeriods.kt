package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdPeriods(
    @SerializedName("first")
    val first: Int? = 0,
    @SerializedName("second")
    val second: Int? = 0
)