package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPaging
import com.google.gson.annotations.SerializedName

data class FixtureByIdPagingDto(
    @SerializedName("current")
    val current: Int = 0,
    @SerializedName("total")
    val total: Int = 0
) {
    internal fun toDomainModel() = FixtureByIdPaging(current, total)
}