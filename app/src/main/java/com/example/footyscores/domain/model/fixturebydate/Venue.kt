package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("city")
    val city: String? = "Oued Zem",
    @SerializedName("id")
    val id: Int? = 1887,
    @SerializedName("name")
    val name: String? = "Stade Municipal"
)