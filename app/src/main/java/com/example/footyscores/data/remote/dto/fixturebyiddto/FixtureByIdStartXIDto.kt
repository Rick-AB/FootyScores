package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdStartXI
import com.google.gson.annotations.SerializedName

data class FixtureByIdStartXIDto(
    @SerializedName("player")
    val player: FixtureByIdPlayerDtoX = FixtureByIdPlayerDtoX()
) {
    internal fun toDomainModel() = FixtureByIdStartXI(player.toDomainModel())
}