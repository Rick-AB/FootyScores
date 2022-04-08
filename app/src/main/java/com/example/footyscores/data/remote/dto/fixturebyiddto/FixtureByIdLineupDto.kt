package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdLineup
import com.google.gson.annotations.SerializedName

data class FixtureByIdLineupDto(
    @SerializedName("coach")
    val coach: FixtureByIdCoachDto = FixtureByIdCoachDto(),
    @SerializedName("formation")
    val formation: String? = "",
    @SerializedName("startXI")
    val startXI: List<FixtureByIdStartXIDto> = listOf(),
    @SerializedName("substitutes")
    val substitutes: List<FixtureByIdSubstituteDto> = listOf(),
    @SerializedName("team")
    val team: FixtureByIdTeamDtoX = FixtureByIdTeamDtoX()
) {
    internal fun toDomainModel() = FixtureByIdLineup(
        coach.toDomainModel(),
        formation,
        startXI.map { it.toDomainModel() },
        substitutes.map { it.toDomainModel() },
        team.toDomainModel()
    )
}