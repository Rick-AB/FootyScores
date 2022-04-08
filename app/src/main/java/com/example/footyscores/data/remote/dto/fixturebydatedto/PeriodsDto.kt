package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Periods
import com.google.gson.annotations.SerializedName

data class PeriodsDto(
    @SerializedName("first")
    val first: Int = 1580997600,
    @SerializedName("second")
    val second: Int = 1580997600
) {
    internal fun toDomainModelPeriods(): Periods {
        return Periods(
            first = first,
            second = second
        )
    }
}