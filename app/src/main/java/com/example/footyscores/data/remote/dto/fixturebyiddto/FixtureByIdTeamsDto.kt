package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdTeams
import com.google.gson.annotations.SerializedName

data class FixtureByIdTeamsDto(
    @SerializedName("away")
    val away: FixtureByIdAwayDto = FixtureByIdAwayDto(),
    @SerializedName("home")
    val home: FixtureByIdHomeDto = FixtureByIdHomeDto()
) {
    internal fun toDomainModel() = FixtureByIdTeams(away.toDomainModel(), home.toDomainModel())
}