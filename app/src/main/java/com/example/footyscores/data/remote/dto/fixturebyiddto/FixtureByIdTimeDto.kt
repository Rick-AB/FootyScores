package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdTime
import com.google.gson.annotations.SerializedName

data class FixtureByIdTimeDto(
    @SerializedName("elapsed")
    val elapsed: Int? = 0,
    @SerializedName("extra")
    val extra: Any? = null
) {
    internal fun toDomainModel() = FixtureByIdTime(elapsed, extra)
}