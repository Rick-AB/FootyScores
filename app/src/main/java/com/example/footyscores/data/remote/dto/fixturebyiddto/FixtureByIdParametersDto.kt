package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdParameters
import com.google.gson.annotations.SerializedName

data class FixtureByIdParametersDto(
    @SerializedName("id")
    val id: String = ""
) {
    internal fun toDomainModel() = FixtureByIdParameters(id)
}