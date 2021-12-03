package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PenaltyDto(
    @SerializedName("away")
    val away: Int? = null,
    @SerializedName("home")
    val home: Int? = null
)