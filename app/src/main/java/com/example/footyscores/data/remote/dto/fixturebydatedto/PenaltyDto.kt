package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Penalty
import com.google.gson.annotations.SerializedName

data class PenaltyDto(
    @SerializedName("away")
    val away: Int? = null,
    @SerializedName("home")
    val home: Int? = null
) {
    internal fun toDomainModelPenalty(): Penalty {
        return Penalty(
            away = away,
            home = home
        )
    }
}