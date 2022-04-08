package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdStatisticX
import com.google.gson.annotations.SerializedName

data class FixtureByIdStatisticDtoX(
    @SerializedName("statistics")
    val statistics: List<FixtureByIdStatisticDtoXX> = listOf(),
    @SerializedName("team")
    val team: FixtureByIdTeamDtoXXX = FixtureByIdTeamDtoXXX()
) {
    internal fun toDomainModel() = FixtureByIdStatisticX(
        statistics.map { it.toDomainModel() },
        team.toDomainModel()
    )
}