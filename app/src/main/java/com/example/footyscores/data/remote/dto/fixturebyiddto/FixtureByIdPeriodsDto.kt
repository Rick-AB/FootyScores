package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPeriods
import com.google.gson.annotations.SerializedName

data class FixtureByIdPeriodsDto(
    @SerializedName("first")
    val first: Int? = 0,
    @SerializedName("second")
    val second: Int? = 0
) {
    internal fun toDomainModel() = FixtureByIdPeriods(first, second)
}