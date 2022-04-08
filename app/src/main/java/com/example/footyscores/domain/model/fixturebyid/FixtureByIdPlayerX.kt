package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdPlayerX(
    @SerializedName("grid")
    val grid: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("number")
    val number: Int? = 0,
    @SerializedName("pos")
    val pos: String? = ""
)