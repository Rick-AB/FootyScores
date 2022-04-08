package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Response
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
) {
   internal fun toDomainModelResponse(): Response {
        return Response(
            fixture = fixture.toDomainModelFixture(),
            goals = goals.toDomainModelGoals(),
            league = league.toDomainModelLeague(),
            score = score.toDomainModelScore(),
            teams = teams.toDomainModelTeams()
            )
    }
}