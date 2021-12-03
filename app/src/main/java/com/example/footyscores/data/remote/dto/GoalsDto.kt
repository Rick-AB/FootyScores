package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GoalsDto(
    @SerializedName("away")
    val away: Int = 3,
    @SerializedName("home")
    val home: Int = 0
)