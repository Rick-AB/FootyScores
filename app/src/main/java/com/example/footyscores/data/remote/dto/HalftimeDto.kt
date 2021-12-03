package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class HalftimeDto(
    @SerializedName("away")
    val away: Int = 1,
    @SerializedName("home")
    val home: Int = 0
)