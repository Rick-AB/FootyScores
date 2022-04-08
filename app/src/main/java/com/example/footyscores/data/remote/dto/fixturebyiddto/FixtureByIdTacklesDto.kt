package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdTackles
import com.google.gson.annotations.SerializedName

data class FixtureByIdTacklesDto(
    @SerializedName("blocks")
    val blocks: Int? = 0,
    @SerializedName("interceptions")
    val interceptions: Int? = 0,
    @SerializedName("total")
    val total: Int? = null
) {
    internal fun toDomainModel() = FixtureByIdTackles(blocks, interceptions, total)
}