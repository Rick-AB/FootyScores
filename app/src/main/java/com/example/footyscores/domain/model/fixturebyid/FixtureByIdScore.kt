package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdScore(
    @SerializedName("extratime")
    val extratime: FixtureByIdExtratime = FixtureByIdExtratime(),
    @SerializedName("fulltime")
    val fulltime: FixtureByIdFulltime = FixtureByIdFulltime(),
    @SerializedName("halftime")
    val halftime: FixtureByIdHalftime = FixtureByIdHalftime(),
    @SerializedName("penalty")
    val penalty: FixtureByIdPenaltyX = FixtureByIdPenaltyX()
)