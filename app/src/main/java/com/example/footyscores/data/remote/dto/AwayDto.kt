package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AwayDto(
    @SerializedName("id")
    val id: Int = 968,
    @SerializedName("logo")
    val logo: String = "https://media.api-sports.io/football/teams/968.png",
    @SerializedName("name")
    val name: String = "Wydad AC",
    @SerializedName("winner")
    val winner: Boolean = true
)