package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LeagueDto(
    @SerializedName("country")
    val country: String = "Morocco",
    @SerializedName("flag")
    val flag: String = "https://media.api-sports.io/flags/ma.svg",
    @SerializedName("id")
    val id: Int = 200,
    @SerializedName("logo")
    val logo: String = "https://media.api-sports.io/football/leagues/115.png",
    @SerializedName("name")
    val name: String = "Botola Pro",
    @SerializedName("round")
    val round: String = "Regular Season - 14",
    @SerializedName("season")
    val season: Int = 2019
)
