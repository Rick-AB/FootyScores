package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdShots
import com.google.gson.annotations.SerializedName

data class FixtureByIdShotsDto(
    @SerializedName("on")
    val on: Int? = 0,
    @SerializedName("total")
    val total: Int? = 0
) {
    internal fun toDomainModel() = FixtureByIdShots(on, total)
}