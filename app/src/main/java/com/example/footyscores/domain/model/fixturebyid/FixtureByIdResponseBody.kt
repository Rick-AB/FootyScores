package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdResponseBody(
    @SerializedName("errors")
    val errors: List<Any> = listOf(),
    @SerializedName("get")
    val `get`: String = "",
    @SerializedName("paging")
    val paging: FixtureByIdPaging = FixtureByIdPaging(),
    @SerializedName("parameters")
    val parameters: FixtureByIdParameters = FixtureByIdParameters(),
    @SerializedName("response")
    val response: List<FixtureByIdResponse> = listOf(),
    @SerializedName("results")
    val results: Int = 0
)