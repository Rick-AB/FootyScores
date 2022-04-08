package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdDribbles
import com.google.gson.annotations.SerializedName

data class FixtureByIdDribblesDto(
    @SerializedName("attempts")
    val attempts: Int? = 0,
    @SerializedName("past")
    val past: Int? = null,
    @SerializedName("success")
    val success: Int? = 0
) {
    internal fun toDomainModel() = FixtureByIdDribbles(
        attempts, past, success
    )
}