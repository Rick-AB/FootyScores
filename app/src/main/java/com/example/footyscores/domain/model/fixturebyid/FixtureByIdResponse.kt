package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdResponse(
    @SerializedName("events")
    val events: List<FixtureByIdEvent> = listOf(),
    @SerializedName("fixture")
    val fixture: FixtureByIdFixture = FixtureByIdFixture(),
    @SerializedName("goals")
    val goals: FixtureByIdGoals = FixtureByIdGoals(),
    @SerializedName("league")
    val league: FixtureByIdLeague = FixtureByIdLeague(),
    @SerializedName("lineups")
    val lineups: List<FixtureByIdLineup> = listOf(),
    @SerializedName("players")
    val players: List<FixtureByIdPlayerXXX> = listOf(),
    @SerializedName("score")
    val score: FixtureByIdScore = FixtureByIdScore(),
    @SerializedName("statistics")
    val statistics: List<FixtureByIdStatisticX> = listOf(),
    @SerializedName("teams")
    val teams: FixtureByIdTeams = FixtureByIdTeams()
)