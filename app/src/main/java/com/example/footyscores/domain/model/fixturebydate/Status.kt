package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("elapsed")
    val elapsed: Int? = 45,
    @SerializedName("long")
    val long: String? = "Halftime",
    @SerializedName("short")
    val short: String? = "HT"
)