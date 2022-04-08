package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdVenue
import com.google.gson.annotations.SerializedName

data class FixtureByIdVenueDto(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
) {
    internal fun toDomainModel() = FixtureByIdVenue(city, id, name)
}