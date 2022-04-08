package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdTime(
    @SerializedName("elapsed")
    val elapsed: Int? = 0,
    @SerializedName("extra")
    val extra: Any? = null
)