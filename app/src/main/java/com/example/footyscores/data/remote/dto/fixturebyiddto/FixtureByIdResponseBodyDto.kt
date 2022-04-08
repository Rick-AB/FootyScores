package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdResponseBody
import com.google.gson.annotations.SerializedName

data class FixtureByIdResponseBodyDto(
    @SerializedName("errors")
    val errors: List<Any> = listOf(),
    @SerializedName("get")
    val `get`: String = "",
    @SerializedName("paging")
    val paging: FixtureByIdPagingDto = FixtureByIdPagingDto(),
    @SerializedName("parameters")
    val parameters: FixtureByIdParametersDto = FixtureByIdParametersDto(),
    @SerializedName("response")
    val response: List<FixtureByIdResponseDto> = listOf(),
    @SerializedName("results")
    val results: Int = 0
) {
    internal fun toDomainModel() = FixtureByIdResponseBody(
        errors,
        get,
        paging.toDomainModel(),
        parameters.toDomainModel(),
        response.map { it.toDomainModel() },
        results
    )
}