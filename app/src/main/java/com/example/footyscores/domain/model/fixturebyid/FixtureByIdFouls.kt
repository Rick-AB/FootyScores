package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdFouls(
    @SerializedName("committed")
    val committed: Int? = 0,
    @SerializedName("drawn")
    val drawn: Int? = 0
)