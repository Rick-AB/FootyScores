package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("fixture")
    val fixture: Fixture = Fixture(),
    @SerializedName("goals")
    val goals: Goals = Goals(),
    @SerializedName("league")
    val league: League = League(),
    @SerializedName("score")
    val score: Score = Score(),
    @SerializedName("teams")
    val teams: Teams = Teams()
)