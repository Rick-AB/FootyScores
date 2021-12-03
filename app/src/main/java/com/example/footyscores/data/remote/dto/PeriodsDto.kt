package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PeriodsDto(
    @SerializedName("first")
    val first: Int = 1580997600,
    @SerializedName("second")
    val second: Int = 1580997600
)