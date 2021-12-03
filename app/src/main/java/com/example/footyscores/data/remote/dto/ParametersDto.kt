package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ParametersDto(
    @SerializedName("live")
    val live: String
)