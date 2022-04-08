package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Parameters
import com.google.gson.annotations.SerializedName

data class ParametersDto(
    @SerializedName("live")
    val live: String
) {
    internal fun toDomainModelParameters(): Parameters {
        return Parameters(live)
    }
}