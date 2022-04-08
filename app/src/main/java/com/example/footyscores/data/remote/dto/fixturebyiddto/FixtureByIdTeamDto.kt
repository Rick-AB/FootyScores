package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdTeam
import com.google.gson.annotations.SerializedName

data class FixtureByIdTeamDto(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("logo")
    val logo: String? = "",
    @SerializedName("name")
    val name: String? = ""
) {
    internal fun toDomainModel() = FixtureByIdTeam(id, logo, name)
}