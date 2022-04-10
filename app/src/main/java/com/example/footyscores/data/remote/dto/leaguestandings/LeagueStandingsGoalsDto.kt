package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsGoals
import com.google.gson.annotations.SerializedName

data class LeagueStandingsGoalsDto(
    @SerializedName("against")
    val against: Int = 0,
    @SerializedName("for")
    val forX: Int = 0
) {
    internal fun toDomainModel(): LeagueStandingsGoals = LeagueStandingsGoals(
        against, forX
    )
}