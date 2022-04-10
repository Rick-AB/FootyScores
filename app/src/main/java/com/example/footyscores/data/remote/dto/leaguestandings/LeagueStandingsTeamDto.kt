package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsTeam
import com.google.gson.annotations.SerializedName

data class LeagueStandingsTeamDto(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = ""
) {
    internal fun toDomainModel(): LeagueStandingsTeam = LeagueStandingsTeam(
        id, logo, name
    )
}