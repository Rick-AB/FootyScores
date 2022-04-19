package com.example.footyscores.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.footyscores.domain.model.fixturebydate.*

@Entity
data class ResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @Embedded(prefix = "fixture_")
    val fixture: Fixture,
    @Embedded(prefix = "goals_")
    val goals: Goals?,
    @Embedded(prefix = "league_")
    val league: League,
    @Embedded(prefix = "score_")
    val score: Score,
    @Embedded(prefix = "teams_")
    val teams: Teams,
    var isFavorite: Boolean = false,
    var date: String? = null
) {
    internal fun toDomainModel() = Response(
        fixture, goals, league, score, teams, isFavorite
    )

    internal fun toResponseEntityUpdateModel() = ResponseEntityUpdate(
        id, fixture, goals, league, score, teams
    )
}