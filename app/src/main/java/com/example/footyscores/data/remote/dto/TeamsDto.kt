package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TeamsDto(
    @SerializedName("away")
    val away: AwayDto = AwayDto(),
    @SerializedName("home")
    val home: HomeDto = HomeDto()
)