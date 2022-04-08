package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdGames(
    @SerializedName("captain")
    val captain: Boolean = false,
    @SerializedName("minutes")
    val minutes: Int? = 0,
    @SerializedName("number")
    val number: Int = 0,
    @SerializedName("position")
    val position: String = "",
    @SerializedName("rating")
    val rating: String? = "",
    @SerializedName("substitute")
    val substitute: Boolean = false
)