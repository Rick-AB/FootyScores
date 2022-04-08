package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Parameters(
    @SerializedName("live")
    val live: String?
)