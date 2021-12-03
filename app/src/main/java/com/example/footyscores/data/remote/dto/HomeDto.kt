package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class HomeDto(
    @SerializedName("id")
    val id: Int = 967,
    @SerializedName("logo")
    val logo: String = "https://media.api-sports.io/football/teams/967.png",
    @SerializedName("name")
    val name: String = "Rapide Oued ZEM",
    @SerializedName("winner")
    val winner: Boolean = false
)