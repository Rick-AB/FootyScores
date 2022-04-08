package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdLineup(
    @SerializedName("coach")
    val coach: FixtureByIdCoach = FixtureByIdCoach(),
    @SerializedName("formation")
    val formation: String? = "",
    @SerializedName("startXI")
    val startXI: List<FixtureByIdStartXI> = listOf(),
    @SerializedName("substitutes")
    val substitutes: List<FixtureByIdSubstitute> = listOf(),
    @SerializedName("team")
    val team: FixtureByIdTeamX = FixtureByIdTeamX()
)