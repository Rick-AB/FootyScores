package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsResponse
import com.google.gson.annotations.SerializedName

data class LeagueStandingsResponseDto(
    @SerializedName("league")
    val league: LeagueStandingsLeagueDto = LeagueStandingsLeagueDto()
) {
    internal fun toDomainModel(): LeagueStandingsResponse = LeagueStandingsResponse(
        league.toDomainModel()
    )
}