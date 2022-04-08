package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Status
import com.google.gson.annotations.SerializedName

data class StatusDto(
    @SerializedName("elapsed")
    val elapsed: Int = 45,
    @SerializedName("long")
    val long: String = "Halftime",
    @SerializedName("short")
    val short: String = "HT"
) {
    internal fun toDomainModelStatus(): Status {
        return Status(
            elapsed = elapsed,
            long = long,
            short = short
        )
    }
}