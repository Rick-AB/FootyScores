package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPenalty
import com.google.gson.annotations.SerializedName

data class FixtureByIdPenaltyDto(
    @SerializedName("commited")
    val commited: Int? = null,
    @SerializedName("missed")
    val missed: Int? = 0,
    @SerializedName("saved")
    val saved: Int? = null,
    @SerializedName("scored")
    val scored: Int? = 0,
    @SerializedName("won")
    val won: Int? = null
) {
    internal fun toDomainModel() = FixtureByIdPenalty(commited, missed, saved, scored, won)
}