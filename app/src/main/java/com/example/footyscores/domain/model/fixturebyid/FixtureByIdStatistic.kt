package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdStatistic(
    @SerializedName("cards")
    val cards: FixtureByIdCards = FixtureByIdCards(),
    @SerializedName("dribbles")
    val dribbles: FixtureByIdDribbles = FixtureByIdDribbles(),
    @SerializedName("duels")
    val duels: FixtureByIdDuels = FixtureByIdDuels(),
    @SerializedName("fouls")
    val fouls: FixtureByIdFouls = FixtureByIdFouls(),
    @SerializedName("games")
    val games: FixtureByIdGames = FixtureByIdGames(),
    @SerializedName("goals")
    val goals: FixtureByIdGoalsX = FixtureByIdGoalsX(),
    @SerializedName("offsides")
    val offsides: Int? = null,
    @SerializedName("passes")
    val passes: FixtureByIdPasses = FixtureByIdPasses(),
    @SerializedName("penalty")
    val penalty: FixtureByIdPenalty = FixtureByIdPenalty(),
    @SerializedName("shots")
    val shots: FixtureByIdShots = FixtureByIdShots(),
    @SerializedName("tackles")
    val tackles: FixtureByIdTackles = FixtureByIdTackles()
)