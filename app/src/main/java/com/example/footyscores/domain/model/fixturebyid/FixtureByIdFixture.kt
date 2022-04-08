package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdFixture(
    @SerializedName("date")
    val date: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("periods")
    val periods: FixtureByIdPeriods = FixtureByIdPeriods(),
    @SerializedName("referee")
    val referee: String? = "",
    @SerializedName("status")
    val status: FixtureByIdStatus = FixtureByIdStatus(),
    @SerializedName("timestamp")
    val timestamp: Int? = 0,
    @SerializedName("timezone")
    val timezone: String? = "",
    @SerializedName("venue")
    val venue: FixtureByIdVenue = FixtureByIdVenue()
)