package com.example.footyscores.data.local.entities

import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.example.footyscores.domain.model.fixturebydate.*

class ResponseEntityUpdate(
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
)