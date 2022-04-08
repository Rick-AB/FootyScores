package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdTeamXXX
import com.google.gson.annotations.SerializedName

data class FixtureByIdTeamDtoXXX(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("logo")
    val logo: String? = "",
    @SerializedName("name")
    val name: String? = ""
) {
    internal fun toDomainModel() = FixtureByIdTeamXXX(id, logo, name)
}