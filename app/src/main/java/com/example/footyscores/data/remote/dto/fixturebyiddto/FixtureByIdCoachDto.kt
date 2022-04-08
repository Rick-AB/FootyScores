package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdCoach
import com.google.gson.annotations.SerializedName

data class FixtureByIdCoachDto(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("photo")
    val photo: String? = ""
) {
    internal fun toDomainModel() = FixtureByIdCoach(
        id, name, photo
    )
}