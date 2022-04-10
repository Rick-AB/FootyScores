package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsHome
import com.google.gson.annotations.SerializedName

data class LeagueStandingsHomeDto(
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
    internal fun toDomainModel(): LeagueStandingsHome = LeagueStandingsHome(
        draw = draw,
        goals = goals.toDomainModel(),
        lose = lose,
        played = played,
        win = win
    )
}