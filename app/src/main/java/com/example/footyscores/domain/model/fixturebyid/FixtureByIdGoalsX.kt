package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdGoalsX(
    @SerializedName("assists")
    val assists: String? = null,
    @SerializedName("conceded")
    val conceded: Int? = 0,
    @SerializedName("saves")
    val saves: Int? = null,
    @SerializedName("total")
    val total: Int? = null
)