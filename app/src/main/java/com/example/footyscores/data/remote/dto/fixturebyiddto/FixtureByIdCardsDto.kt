package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdCards
import com.google.gson.annotations.SerializedName

data class FixtureByIdCardsDto(
    @SerializedName("red")
    val red: Int? = 0,
    @SerializedName("yellow")
    val yellow: Int? = 0
) {
    internal fun toDomainModel() = FixtureByIdCards(
        red, yellow
    )
}