package com.example.footyscores.domain.model.fixturebydate


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Fixture(
    @SerializedName("date")
    val date: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("periods")
    @Embedded(prefix = "periods_")
    val periods: Periods,

    @SerializedName("referee")
    val referee: String?,

    @SerializedName("status")
    @Embedded(prefix = "status_")
    val status: Status,

    @SerializedName("timestamp")
    val timestamp: Int?,

    @SerializedName("timezone")
    val timezone: String?,

    @SerializedName("venue")
    @Embedded(prefix = "venue_")
    val venue: Venue
)