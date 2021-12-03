package com.example.footyscores.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ScoreDto(
    @SerializedName("extratime")
    val extratime: ExtratimeDto = ExtratimeDto(),
    @SerializedName("fulltime")
    val fulltime: FulltimeDto = FulltimeDto(),
    @SerializedName("halftime")
    val halftime: HalftimeDto = HalftimeDto(),
    @SerializedName("penalty")
    val penalty: PenaltyDto = PenaltyDto()
)