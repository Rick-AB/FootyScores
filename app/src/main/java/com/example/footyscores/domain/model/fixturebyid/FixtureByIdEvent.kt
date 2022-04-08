package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdEvent(
    @SerializedName("assist")
    val assist: FixtureByIdAssist = FixtureByIdAssist(),
    @SerializedName("comments")
    val comments: String? = null,
    @SerializedName("detail")
    val detail: String? = "",
    @SerializedName("player")
    val player: FixtureByIdPlayer = FixtureByIdPlayer(),
    @SerializedName("team")
    val team: FixtureByIdTeam = FixtureByIdTeam(),
    @SerializedName("time")
    val time: FixtureByIdTime = FixtureByIdTime(),
    @SerializedName("type")
    val type: String? = ""
)