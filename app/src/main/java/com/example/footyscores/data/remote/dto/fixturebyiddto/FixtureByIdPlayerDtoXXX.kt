package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPlayerXXX
import com.google.gson.annotations.SerializedName

data class FixtureByIdPlayerDtoXXX(
    @SerializedName("players")
    val players: List<FixtureByIdPlayerDtoXXXX> = listOf(),
    @SerializedName("team")
    val team: FixtureByIdTeamDtoXX = FixtureByIdTeamDtoXX()
) {
    internal fun toDomainModel() = FixtureByIdPlayerXXX(
        players.map { it.toDomainModel() },
        team.toDomainModel()
    )
}