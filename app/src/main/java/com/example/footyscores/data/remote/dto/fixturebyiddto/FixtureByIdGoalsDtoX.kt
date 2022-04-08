package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdGoalsX
import com.google.gson.annotations.SerializedName

data class FixtureByIdGoalsDtoX(
    @SerializedName("assists")
    val assists: String? = null,
    @SerializedName("conceded")
    val conceded: Int? = 0,
    @SerializedName("saves")
    val saves: Int? = null,
    @SerializedName("total")
    val total: Int? = null
) {
    internal fun toDomainModel() = FixtureByIdGoalsX(assists, conceded, saves, total)
}