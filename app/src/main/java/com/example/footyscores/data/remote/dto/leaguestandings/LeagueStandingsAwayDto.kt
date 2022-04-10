package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsAway
import com.google.gson.annotations.SerializedName

data class LeagueStandingsAwayDto(
    @SerializedName("draw")
    val draw: Int = 0,
    @SerializedName("goals")
    val goals: LeagueStandingsGoalsDto = LeagueStandingsGoalsDto(),
    @SerializedName("lose")
    val lose: Int = 0,
    @SerializedName("played")
    val played: Int = 0,
    @SerializedName("win")
    val win: Int = 0
) {
    internal fun toDomainModel(): LeagueStandingsAway = LeagueStandingsAway(
        draw = draw,
        goals = goals.toDomainModel(),
        lose = lose,
        played = played,
        win = win
    )
}