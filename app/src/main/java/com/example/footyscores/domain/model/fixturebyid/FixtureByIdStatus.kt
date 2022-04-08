package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdStatus(
    @SerializedName("elapsed")
    val elapsed: Int? = 0,
    @SerializedName("long")
    val long: String? = "",
    @SerializedName("short")
    val short: String? = ""
)