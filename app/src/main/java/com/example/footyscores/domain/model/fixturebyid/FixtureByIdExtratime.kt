package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdExtratime(
    @SerializedName("away")
    val away: Int? = null,
    @SerializedName("home")
    val home: Int? = null
)