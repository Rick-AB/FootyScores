package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdResponse
import com.google.gson.annotations.SerializedName

data class FixtureByIdResponseDto(
    @SerializedName("events")
    val events: List<FixtureByIdEventDto> = listOf(),
    @SerializedName("fixture")
    val fixture: FixtureByIdFixtureDto = FixtureByIdFixtureDto(),
    @SerializedName("goals")
    val goals: FixtureByIdGoalsDto = FixtureByIdGoalsDto(),
    @SerializedName("league")
    val league: FixtureByIdLeagueDto = FixtureByIdLeagueDto(),
    @SerializedName("lineups")
    val lineups: List<FixtureByIdLineupDto> = listOf(),
    @SerializedName("players")
    val players: List<FixtureByIdPlayerDtoXXX> = listOf(),
    @SerializedName("score")
    val score: FixtureByIdScoreDto = FixtureByIdScoreDto(),
    @SerializedName("statistics")
    val statistics: List<FixtureByIdStatisticDtoX> = listOf(),
    @SerializedName("teams")
    val teams: FixtureByIdTeamsDto = FixtureByIdTeamsDto()
) {
    internal fun toDomainModel() = FixtureByIdResponse(
        events.map { it.toDomainModel() },
        fixture.toDomainModel(),
        goals.toDomainModel(),
        league.toDomainModel(),
        lineups.map { it.toDomainModel() },
        players.map { it.toDomainModel() },
        score.toDomainModel(),
        statistics.map { it.toDomainModel() },
        teams.toDomainModel(),
    )
}