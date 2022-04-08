package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Score
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
) {
    internal fun toDomainModelScore(): Score {
        return Score(
            extratime = extratime.toDomainModelExtratime(),
            fulltime = fulltime.toDomainModelFulltime(),
            halftime = halftime.toDomainModelHalftime(),
            penalty = penalty.toDomainModelPenalty(),
        )
    }
}