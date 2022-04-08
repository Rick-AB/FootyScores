package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("extratime")
    val extratime: Extratime = Extratime(),
    @SerializedName("fulltime")
    val fulltime: Fulltime = Fulltime(),
    @SerializedName("halftime")
    val halftime: Halftime = Halftime(),
    @SerializedName("penalty")
    val penalty: Penalty = Penalty()
)