package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdAssist
import com.google.gson.annotations.SerializedName

data class FixtureByIdAssistDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
) {
    internal fun toDomainModel() = FixtureByIdAssist(
        id = id,
        name = name
    )
}


