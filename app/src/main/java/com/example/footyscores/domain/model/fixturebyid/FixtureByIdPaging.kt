package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdPaging(
    @SerializedName("current")
    val current: Int = 0,
    @SerializedName("total")
    val total: Int = 0
)