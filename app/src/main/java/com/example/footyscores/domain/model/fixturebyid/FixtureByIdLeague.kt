package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdLeague(
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("flag")
    val flag: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("logo")
    val logo: String? = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("round")
    val round: String? = "",
    @SerializedName("season")
    val season: Int? = 0
)