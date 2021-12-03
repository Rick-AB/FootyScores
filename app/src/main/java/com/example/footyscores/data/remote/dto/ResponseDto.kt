package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("fixture")
    val fixture: FixtureDto = FixtureDto(),
    @SerializedName("goals")
    val goals: GoalsDto = GoalsDto(),
    @SerializedName("league")
    val league: LeagueDto = LeagueDto(),
    @SerializedName("score")
    val score: ScoreDto = ScoreDto(),
    @SerializedName("teams")
    val teams: TeamsDto = TeamsDto()
)