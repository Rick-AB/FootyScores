package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdPenalty(
    @SerializedName("commited")
    val commited: Int? = null,
    @SerializedName("missed")
    val missed: Int? = 0,
    @SerializedName("saved")
    val saved: Int? = null,
    @SerializedName("scored")
    val scored: Int? = 0,
    @SerializedName("won")
    val won: Int? = null
)