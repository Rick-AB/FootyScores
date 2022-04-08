package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPasses
import com.google.gson.annotations.SerializedName

data class FixtureByIdPassesDto(
    @SerializedName("accuracy")
    val accuracy: String? = "",
    @SerializedName("key")
    val key: Int? = 0,
    @SerializedName("total")
    val total: Int? = 0
) {
    internal fun toDomainModel() = FixtureByIdPasses(accuracy, key, total)
}