package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdDribbles(
    @SerializedName("attempts")
    val attempts: Int? = 0,
    @SerializedName("past")
    val past: Int? = null,
    @SerializedName("success")
    val success: Int? = 0
)