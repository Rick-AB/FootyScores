package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPlayerX
import com.google.gson.annotations.SerializedName

data class FixtureByIdPlayerDtoX(
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
) {
    internal fun toDomainModel() = FixtureByIdPlayerX(grid, id, name, number, pos)
}