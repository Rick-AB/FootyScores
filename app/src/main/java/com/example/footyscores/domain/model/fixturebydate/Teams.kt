package com.example.footyscores.domain.model.fixturebydate


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Teams(
    @SerializedName("away")
    @Embedded(prefix = "away_")
    val away: Away,

    @SerializedName("home")
    @Embedded(prefix = "home_")
    val home: Home
)