package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdDuels
import com.google.gson.annotations.SerializedName

data class FixtureByIdDuelsDto(
    @SerializedName("total")
    val total: Int? = 0,
    @SerializedName("won")
    val won: Int? = 0
) {
    internal fun toDomainModel() = FixtureByIdDuels(
        total, won
    )
}