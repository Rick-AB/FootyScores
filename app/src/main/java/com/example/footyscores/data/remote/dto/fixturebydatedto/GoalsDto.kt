package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Goals
import com.google.gson.annotations.SerializedName

data class GoalsDto(
    @SerializedName("away")
    val away: Int?,
    @SerializedName("home")
    val home: Int?
) {
    internal fun toDomainModelGoals(): Goals {
        return Goals(
            away = away,
            home = home
        )
    }
}