package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdTeamX
import com.google.gson.annotations.SerializedName

data class FixtureByIdTeamDtoX(
    @SerializedName("colors")
    val colors: Any? = null,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = ""
) {
    internal fun toDomainModel() = FixtureByIdTeamX(colors, id, logo, name)
}