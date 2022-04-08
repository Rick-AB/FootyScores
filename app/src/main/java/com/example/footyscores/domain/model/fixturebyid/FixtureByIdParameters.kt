package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdParameters(
    @SerializedName("id")
    val id: String = ""
)