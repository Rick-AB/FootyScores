package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdStatisticXX(
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("value")
    val value: Any? = null
)