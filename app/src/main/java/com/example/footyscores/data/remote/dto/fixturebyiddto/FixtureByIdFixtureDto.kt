package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdFixture
import com.google.gson.annotations.SerializedName

data class FixtureByIdFixtureDto(
    @SerializedName("date")
    val date: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("periods")
    val periods: FixtureByIdPeriodsDto = FixtureByIdPeriodsDto(),
    @SerializedName("referee")
    val referee: String? = "",
    @SerializedName("status")
    val status: FixtureByIdStatusDto = FixtureByIdStatusDto(),
    @SerializedName("timestamp")
    val timestamp: Int? = 0,
    @SerializedName("timezone")
    val timezone: String? = "",
    @SerializedName("venue")
    val venue: FixtureByIdVenueDto = FixtureByIdVenueDto()
) {
    internal fun toDomainModel() = FixtureByIdFixture(
        date,
        id,
        periods.toDomainModel(),
        referee,
        status.toDomainModel(),
        timestamp,
        timezone,
        venue.toDomainModel()
    )
}