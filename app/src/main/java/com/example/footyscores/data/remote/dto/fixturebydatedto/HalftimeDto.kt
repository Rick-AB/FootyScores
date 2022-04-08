package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Halftime
import com.google.gson.annotations.SerializedName

data class HalftimeDto(
    @SerializedName("away")
    val away: Int = 1,
    @SerializedName("home")
    val home: Int = 0
) {
    internal fun toDomainModelHalftime(): Halftime {
        return Halftime(
            away = away,
            home = home
        )
    }
}