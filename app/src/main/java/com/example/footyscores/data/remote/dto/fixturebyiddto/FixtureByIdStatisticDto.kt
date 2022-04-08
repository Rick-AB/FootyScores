package com.example.footyscores.data.remote.dto.fixturebyiddto


import com.example.footyscores.domain.model.fixturebyid.FixtureByIdStatistic
import com.google.gson.annotations.SerializedName

data class FixtureByIdStatisticDto(
    @SerializedName("cards")
    val cards: FixtureByIdCardsDto = FixtureByIdCardsDto(),
    @SerializedName("dribbles")
    val dribbles: FixtureByIdDribblesDto = FixtureByIdDribblesDto(),
    @SerializedName("duels")
    val duels: FixtureByIdDuelsDto = FixtureByIdDuelsDto(),
    @SerializedName("fouls")
    val fouls: FixtureByIdFoulsDto = FixtureByIdFoulsDto(),
    @SerializedName("games")
    val games: FixtureByIdGamesDto = FixtureByIdGamesDto(),
    @SerializedName("goals")
    val goals: FixtureByIdGoalsDtoX = FixtureByIdGoalsDtoX(),
    @SerializedName("offsides")
    val offsides: Int? = null,
    @SerializedName("passes")
    val passes: FixtureByIdPassesDto = FixtureByIdPassesDto(),
    @SerializedName("penalty")
    val penalty: FixtureByIdPenaltyDto = FixtureByIdPenaltyDto(),
    @SerializedName("shots")
    val shots: FixtureByIdShotsDto = FixtureByIdShotsDto(),
    @SerializedName("tackles")
    val tackles: FixtureByIdTacklesDto = FixtureByIdTacklesDto()
) {
    internal fun toDomainModel() = FixtureByIdStatistic(
        cards.toDomainModel(),
        dribbles.toDomainModel(),
        duels.toDomainModel(),
        fouls.toDomainModel(),
        games.toDomainModel(),
        goals.toDomainModel(),
        offsides,
        passes.toDomainModel(),
        penalty.toDomainModel(),
        shots.toDomainModel(),
        tackles.toDomainModel()

    )
}