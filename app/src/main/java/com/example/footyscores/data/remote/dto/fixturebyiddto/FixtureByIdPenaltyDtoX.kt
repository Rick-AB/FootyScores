package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPenaltyX
import com.google.gson.annotations.SerializedName

data class FixtureByIdPenaltyDtoX(
    @SerializedName("away")
    val away: Int? = null,
    @SerializedName("home")
    val home: Int? = null
) {
    internal fun toDomainModel() = FixtureByIdPenaltyX(away, home)
}