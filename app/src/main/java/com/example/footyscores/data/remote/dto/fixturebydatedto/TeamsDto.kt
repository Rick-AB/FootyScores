package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Teams
import com.google.gson.annotations.SerializedName

data class TeamsDto(
    @SerializedName("away")
    val away: AwayDto = AwayDto(),
    @SerializedName("home")
    val home: HomeDto = HomeDto()
) {
    internal fun toDomainModelTeams(): Teams {
        return Teams(
            away = away.toDomainModelAway(),
            home = home.toDomainModelHome()
        )
    }
}