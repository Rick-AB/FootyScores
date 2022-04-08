package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Periods(
    @SerializedName("first")
    val first: Int? = 1580997600,
    @SerializedName("second")
    val second: Int? = 1580997600
)