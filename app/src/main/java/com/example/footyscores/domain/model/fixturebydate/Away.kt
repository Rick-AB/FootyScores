package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Away(
    @SerializedName("id")
    val id: Int? = 968,
    @SerializedName("logo")
    val logo: String? = "https://media.api-sports.io/football/teams/968.png",
    @SerializedName("name")
    val name: String? = "Wydad AC",
    @SerializedName("winner")
    val winner: Boolean? = true
)