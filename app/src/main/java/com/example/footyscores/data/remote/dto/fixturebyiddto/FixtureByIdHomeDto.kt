package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdHome
import com.google.gson.annotations.SerializedName

data class FixtureByIdHomeDto(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("winner")
    val winner: Boolean? = false
) {
    internal fun toDomainModel() = FixtureByIdHome(id, logo, name, winner)
}