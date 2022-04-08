package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdTeamXX
import com.google.gson.annotations.SerializedName

data class FixtureByIdTeamDtoXX(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("logo")
    val logo: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("update")
    val update: String? = ""
) {
    internal fun toDomainModel() = FixtureByIdTeamXX(id, logo, name, update)
}