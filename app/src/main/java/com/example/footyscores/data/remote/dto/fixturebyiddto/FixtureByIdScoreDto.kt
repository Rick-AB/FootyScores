package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdScore
import com.google.gson.annotations.SerializedName

data class FixtureByIdScoreDto(
    @SerializedName("extratime")
    val extratime: FixtureByIdExtratimeDto = FixtureByIdExtratimeDto(),
    @SerializedName("fulltime")
    val fulltime: FixtureByIdFulltimeDto = FixtureByIdFulltimeDto(),
    @SerializedName("halftime")
    val halftime: FixtureByIdHalftimeDto = FixtureByIdHalftimeDto(),
    @SerializedName("penalty")
    val penalty: FixtureByIdPenaltyDtoX = FixtureByIdPenaltyDtoX()
) {
    internal fun toDomainModel() = FixtureByIdScore(
        extratime.toDomainModel(),
        fulltime.toDomainModel(),
        halftime.toDomainModel(),
        penalty.toDomainModel()
    )
}