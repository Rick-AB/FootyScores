package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Penalty(
    @SerializedName("away")
    val away: Int? = null,
    @SerializedName("home")
    val home: Int? = null
)