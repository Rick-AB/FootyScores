package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("city")
    val city: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)