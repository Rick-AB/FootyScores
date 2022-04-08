package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdGames
import com.google.gson.annotations.SerializedName

data class FixtureByIdGamesDto(
    @SerializedName("captain")
    val captain: Boolean = false,
    @SerializedName("minutes")
    val minutes: Int? = 0,
    @SerializedName("number")
    val number: Int = 0,
    @SerializedName("position")
    val position: String = "",
    @SerializedName("rating")
    val rating: String? = "",
    @SerializedName("substitute")
    val substitute: Boolean = false
) {
    internal fun toDomainModel() =
        FixtureByIdGames(captain, minutes, number, position, rating, substitute)
}