package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Venue
import com.google.gson.annotations.SerializedName

data class VenueDto(
    @SerializedName("city")
    val city: String = "Oued Zem",
    @SerializedName("id")
    val id: Int = 1887,
    @SerializedName("name")
    val name: String = "Stade Municipal"
) {
    internal fun toDomainModelVenue(): Venue {
        return Venue(
            city = city,
            id = id,
            name = name
        )
    }
}