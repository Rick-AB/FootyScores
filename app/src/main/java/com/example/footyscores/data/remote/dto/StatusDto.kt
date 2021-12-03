package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class StatusDto(
    @SerializedName("elapsed")
    val elapsed: Int = 45,
    @SerializedName("long")
    val long: String = "Halftime",
    @SerializedName("short")
    val short: String = "HT"
)