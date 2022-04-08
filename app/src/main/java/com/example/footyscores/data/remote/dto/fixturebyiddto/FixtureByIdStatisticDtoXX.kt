package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdStatisticXX
import com.google.gson.annotations.SerializedName

data class FixtureByIdStatisticDtoXX(
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("value")
    val value: Any? = null
) {
    internal fun toDomainModel() = FixtureByIdStatisticXX(type, value)
}