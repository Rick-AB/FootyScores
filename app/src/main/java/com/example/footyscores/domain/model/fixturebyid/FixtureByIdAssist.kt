package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdAssist(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)