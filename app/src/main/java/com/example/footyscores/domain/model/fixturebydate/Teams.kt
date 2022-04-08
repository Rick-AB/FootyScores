package com.example.footyscores.domain.model.fixturebydate


import com.google.gson.annotations.SerializedName

data class Teams(
    @SerializedName("away")
    val away: Away = Away(),
    @SerializedName("home")
    val home: Home = Home()
)