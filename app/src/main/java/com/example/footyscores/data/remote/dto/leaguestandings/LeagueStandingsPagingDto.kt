package com.example.footyscores.data.remote.dto.leaguestandings


import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsPaging
import com.google.gson.annotations.SerializedName

data class LeagueStandingsPagingDto(
    @SerializedName("current")
    val current: Int = 0,
    @SerializedName("total")
    val total: Int = 0
) {
    internal fun toDomainModel(): LeagueStandingsPaging = LeagueStandingsPaging(
        current, total
    )
}