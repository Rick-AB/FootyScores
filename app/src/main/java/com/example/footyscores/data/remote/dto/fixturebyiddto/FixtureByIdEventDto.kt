package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdEvent
import com.google.gson.annotations.SerializedName

data class FixtureByIdEventDto(
    @SerializedName("assist")
    val assist: FixtureByIdAssistDto = FixtureByIdAssistDto(),
    @SerializedName("comments")
    val comments: String? = null,
    @SerializedName("detail")
    val detail: String? = "",
    @SerializedName("player")
    val player: FixtureByIdPlayerDto = FixtureByIdPlayerDto(),
    @SerializedName("team")
    val team: FixtureByIdTeamDto = FixtureByIdTeamDto(),
    @SerializedName("time")
    val time: FixtureByIdTimeDto = FixtureByIdTimeDto(),
    @SerializedName("type")
    val type: String? = ""
) {
    internal fun toDomainModel() = FixtureByIdEvent(
        assist = assist.toDomainModel(),
        comments = comments,
        detail = detail,
        player = player.toDomainModel(),
        team = team.toDomainModel(),
        time = time.toDomainModel(),
        type = type
    )
}