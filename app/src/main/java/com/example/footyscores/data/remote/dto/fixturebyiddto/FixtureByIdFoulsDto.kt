package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdFouls
import com.google.gson.annotations.SerializedName

data class FixtureByIdFoulsDto(
    @SerializedName("committed")
    val committed: Int? = 0,
    @SerializedName("drawn")
    val drawn: Int? = 0
) {
    internal fun toDomainModel() = FixtureByIdFouls(committed, drawn)
}