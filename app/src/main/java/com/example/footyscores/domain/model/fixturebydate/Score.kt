package com.example.footyscores.domain.model.fixturebydate


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("extratime")
    @Embedded(prefix = "extratime_")
    val extratime: Extratime?,

    @SerializedName("fulltime")
    @Embedded(prefix = "fulltime_")
    val fulltime: Fulltime?,

    @SerializedName("halftime")
    @Embedded(prefix = "halftime_")
    val halftime: Halftime?,

    @SerializedName("penalty")
    @Embedded(prefix = "penalty_")
    val penalty: Penalty?
)