package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdTackles(
    @SerializedName("blocks")
    val blocks: Int? = 0,
    @SerializedName("interceptions")
    val interceptions: Int? = 0,
    @SerializedName("total")
    val total: Int? = null
)