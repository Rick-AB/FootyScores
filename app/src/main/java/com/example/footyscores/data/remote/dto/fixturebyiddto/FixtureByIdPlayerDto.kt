package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPlayer
import com.google.gson.annotations.SerializedName

data class FixtureByIdPlayerDto(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
) {
    internal fun toDomainModel() = FixtureByIdPlayer(id, name)
}