package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsParameters
import com.google.gson.annotations.SerializedName

data class LeagueStandingsParametersDto(
    @SerializedName("league")
    val league: String = "",
    @SerializedName("season")
    val season: String = ""
) {
    internal fun toDomainModel(): LeagueStandingsParameters = LeagueStandingsParameters(
        league, season
    )
}