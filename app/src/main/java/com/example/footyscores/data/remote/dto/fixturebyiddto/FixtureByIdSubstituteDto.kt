package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdSubstitute
import com.google.gson.annotations.SerializedName

data class FixtureByIdSubstituteDto(
    @SerializedName("player")
    val player: FixtureByIdPlayerDtoX = FixtureByIdPlayerDtoX()
) {
    internal fun toDomainModel() = FixtureByIdSubstitute(
        player.toDomainModel()
    )
}