package com.example.footyscores.domain.model.fixturebyid


import com.google.gson.annotations.SerializedName

data class FixtureByIdPasses(
    @SerializedName("accuracy")
    val accuracy: String? = "",
    @SerializedName("key")
    val key: Int? = 0,
    @SerializedName("total")
    val total: Int? = 0
)