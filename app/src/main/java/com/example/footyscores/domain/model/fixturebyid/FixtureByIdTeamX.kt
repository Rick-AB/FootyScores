package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdTeamX(
    @SerializedName("colors")
    val colors: Any? = null,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = ""
)