package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPlayerXXXX
import com.google.gson.annotations.SerializedName

data class FixtureByIdPlayerDtoXXXX(
    @SerializedName("player")
    val player: FixtureByIdPlayerDtoXXXXX = FixtureByIdPlayerDtoXXXXX(),
    @SerializedName("statistics")
    val statistics: List<FixtureByIdStatisticDto> = listOf()
) {
    internal fun toDomainModel() = FixtureByIdPlayerXXXX(
        player.toDomainModel(),
        statistics.map { it.toDomainModel() }
    )
}