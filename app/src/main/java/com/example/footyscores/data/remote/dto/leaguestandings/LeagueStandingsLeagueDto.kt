package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsLeague
import com.google.gson.annotations.SerializedName

data class LeagueStandingsLeagueDto(
    @SerializedName("country")
    val country: String = "",
    @SerializedName("flag")
    val flag: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("season")
    val season: Int = 0,
    @SerializedName("standings")
    val standings: List<List<LeagueStandingsStandingDto>> = listOf()
) {
    internal fun toDomainModel(): LeagueStandingsLeague = LeagueStandingsLeague(
        country, flag, id, logo, name, season, standings = standings.map { it.map { it.toDomainModel() } }
    )
}