package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Fulltime
import com.google.gson.annotations.SerializedName

data class FulltimeDto(
    @SerializedName("away")
    val away: Int = 3,
    @SerializedName("home")
    val home: Int = 0
) {
    internal fun toDomainModelFulltime(): Fulltime {
        return Fulltime(
            away = away,
            home = home
        )
    }
}