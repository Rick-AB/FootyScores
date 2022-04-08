package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Goals(
    @SerializedName("away")
    val away: Int? = 3,
    @SerializedName("home")
    val home: Int? = 0
)