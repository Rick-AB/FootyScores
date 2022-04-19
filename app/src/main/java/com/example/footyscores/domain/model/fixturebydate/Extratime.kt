package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Extratime(
    @SerializedName("away")
    val away: Int?,
    @SerializedName("home")
    val home: Int?
)