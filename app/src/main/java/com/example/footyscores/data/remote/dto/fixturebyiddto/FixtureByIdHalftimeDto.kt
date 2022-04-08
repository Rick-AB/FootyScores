package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdHalftime
import com.google.gson.annotations.SerializedName

data class FixtureByIdHalftimeDto(
    @SerializedName("away")
    val away: Int? = 0,
    @SerializedName("home")
    val home: Int? = 0
) {
    internal fun toDomainModel() = FixtureByIdHalftime(away, home)
}