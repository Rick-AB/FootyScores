package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdExtratime
import com.google.gson.annotations.SerializedName

data class FixtureByIdExtratimeDto(
    @SerializedName("away")
    val away: Int? = null,
    @SerializedName("home")
    val home: Int? = null
) {
    internal fun toDomainModel() = FixtureByIdExtratime(
        away, home
    )
}