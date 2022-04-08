package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdStatus
import com.google.gson.annotations.SerializedName

data class FixtureByIdStatusDto(
    @SerializedName("elapsed")
    val elapsed: Int? = 0,
    @SerializedName("long")
    val long: String? = "",
    @SerializedName("short")
    val short: String? = ""
) {
    internal fun toDomainModel() = FixtureByIdStatus(elapsed, long, short)
}