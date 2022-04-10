package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsResponseBody
import com.google.gson.annotations.SerializedName

data class LeagueStandingsResponseBodyDto(
    @SerializedName("errors")
    val errors: List<Any> = listOf(),
    @SerializedName("get")
    val `get`: String = "",
    @SerializedName("paging")
    val paging: LeagueStandingsPagingDto = LeagueStandingsPagingDto(),
    @SerializedName("parameters")
    val parameters: LeagueStandingsParametersDto = LeagueStandingsParametersDto(),
    @SerializedName("response")
    val response: List<LeagueStandingsResponseDto> = listOf(),
    @SerializedName("results")
    val results: Int = 0
) {
    internal fun toDomainModel(): LeagueStandingsResponseBody = LeagueStandingsResponseBody(
        errors,
        get,
        paging.toDomainModel(),
        parameters.toDomainModel(),
        response.map { it.toDomainModel() },
        results
    )
}