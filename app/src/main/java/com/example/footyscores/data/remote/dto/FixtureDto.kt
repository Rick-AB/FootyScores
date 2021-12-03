package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class FixtureDto(
    @SerializedName("date")
    val date: String = "2020-02-06T14:00:00+00:00",
    @SerializedName("id")
    val id: Int = 239625,
    @SerializedName("periods")
    val periods: PeriodsDto = PeriodsDto(),
    @SerializedName("referee")
    val referee: String = "Mike Dean",
    @SerializedName("status")
    val status: StatusDto = StatusDto(),
    @SerializedName("timestamp")
    val timestamp: Int = 1580997600,
    @SerializedName("timezone")
    val timezone: String = "UTC",
    @SerializedName("venue")
    val venue: VenueDto = VenueDto()
)