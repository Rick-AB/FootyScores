package com.example.footyscores.domain.model.leaguestandings


import com.google.gson.annotations.SerializedName

data class LeagueStandingsStanding(
    @SerializedName("all")
    val all: LeagueStandingsAll = LeagueStandingsAll(),
    @SerializedName("away")
    val away: LeagueStandingsAway = LeagueStandingsAway(),
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("form")
    val form: String = "",
    @SerializedName("goalsDiff")
    val goalsDiff: Int = 0,
    @SerializedName("group")
    val group: String = "",
    @SerializedName("home")
    val home: LeagueStandingsHome = LeagueStandingsHome(),
    @SerializedName("points")
    val points: Int = 0,
    @SerializedName("rank")
    val rank: Int = 0,
    @SerializedName("status")
    val status: String = "",
    @SerializedName("team")
    val team: LeagueStandingsTeam = LeagueStandingsTeam(),
    @SerializedName("update")
    val update: String = ""
)