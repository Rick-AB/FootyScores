package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Extratime
import com.google.gson.annotations.SerializedName

data class ExtratimeDto(
    @SerializedName("away")
    val away: Int? = null,
    @SerializedName("home")
    val home: Int? = null
) {
    internal fun toDomainModelExtratime(): Extratime {
        return Extratime(
            away = away,
            home = home
        )
    }
}