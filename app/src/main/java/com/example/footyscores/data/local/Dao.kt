package com.example.footyscores.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.footyscores.data.local.entities.ResponseEntity
import com.example.footyscores.data.local.entities.ResponseEntityUpdate
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    suspend fun insertFixtures(fixtures: List<ResponseEntity>)

    @Update(entity = ResponseEntity::class)
    suspend fun updateFixtures(fixtures: List<ResponseEntityUpdate>)

    @Query("UPDATE ResponseEntity SET isFavorite = :favoriteStatus WHERE fixture_id = :fixtureId")
    suspend fun updateFixtureFavoriteStatus(fixtureId: Int, favoriteStatus: Boolean)

    @Query("DELETE FROM ResponseEntity WHERE date = :date")
    suspend fun deleteFixturesByDate(date: String)

    @Query("SELECT * FROM ResponseEntity WHERE date = :date")
    fun getFixturesByDate(date: String): Flow<List<ResponseEntity>>

    @Query("SELECT * FROM ResponseEntity WHERE isFavorite = :favoriteStatus")
    suspend fun getFavoriteFixtures(favoriteStatus: Boolean): List<ResponseEntity>
}