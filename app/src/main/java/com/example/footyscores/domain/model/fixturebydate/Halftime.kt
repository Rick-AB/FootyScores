package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Halftime(
    @SerializedName("away")
    val away: Int?,
    @SerializedName("home")
    val home: Int?
)