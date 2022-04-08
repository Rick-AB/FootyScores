package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdPlayerXXXXX
import com.google.gson.annotations.SerializedName

data class FixtureByIdPlayerDtoXXXXX(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("photo")
    val photo: String? = ""
) {
    internal fun toDomainModel() = FixtureByIdPlayerXXXXX(id, name, photo)
}