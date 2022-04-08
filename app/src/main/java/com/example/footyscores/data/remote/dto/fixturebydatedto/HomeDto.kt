package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Home
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
) {
    internal fun toDomainModelHome(): Home {
        return Home(
            id = id,
            logo = logo,
            name = name,
            winner = winner
        )
    }
}