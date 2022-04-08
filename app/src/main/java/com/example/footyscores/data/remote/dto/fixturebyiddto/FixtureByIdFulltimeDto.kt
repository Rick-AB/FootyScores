package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdFulltime
import com.google.gson.annotations.SerializedName

data class FixtureByIdFulltimeDto(
    @SerializedName("away")
    val away: Int? = 0,
    @SerializedName("home")
    val home: Int? = 0
) {
    internal fun toDomainModel() = FixtureByIdFulltime(away, home)
}