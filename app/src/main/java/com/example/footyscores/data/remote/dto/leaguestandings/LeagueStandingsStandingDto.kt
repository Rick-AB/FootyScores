package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsStanding
import com.google.gson.annotations.SerializedName

data class LeagueStandingsStandingDto(
    @SerializedName("all")
    val all: LeagueStandingsAllDto = LeagueStandingsAllDto(),
    @SerializedName("away")
    val away: LeagueStandingsAwayDto = LeagueStandingsAwayDto(),
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("form")
    val form: String = "",
    @SerializedName("goalsDiff")
    val goalsDiff: Int = 0,
    @SerializedName("group")
    val group: String = "",
    @SerializedName("home")
    val home: LeagueStandingsHomeDto = LeagueStandingsHomeDto(),
    @SerializedName("points")
    val points: Int = 0,
    @SerializedName("rank")
    val rank: Int = 0,
    @SerializedName("status")
    val status: String = "",
    @SerializedName("team")
    val team: LeagueStandingsTeamDto = LeagueStandingsTeamDto(),
    @SerializedName("update")
    val update: String = ""
) {
    internal fun toDomainModel(): LeagueStandingsStanding = LeagueStandingsStanding(
        all.toDomainModel(),
        away.toDomainModel(),
        description,
        form, goalsDiff, group,
        home.toDomainModel(),
        points, rank, status,
        team.toDomainModel(),
        update
    )
}