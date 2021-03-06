package com.example.footyscores.data.local

import androidx.room.*
import androidx.room.Dao
import com.example.footyscores.data.local.entities.ResponseEntity
import com.example.footyscores.data.local.entities.ResponseEntityUpdate
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(fixtures: List<ResponseEntity>)

    @Update(entity = ResponseEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFixtures(fixtures: List<ResponseEntityUpdate>)

    @Query("UPDATE ResponseEntity SET isFavorite = :favoriteStatus WHERE fixture_id = :fixtureId")
    suspend fun updateFixtureFavoriteStatus(fixtureId: Int, favoriteStatus: Boolean)

    @Query("DELETE FROM ResponseEntity WHERE date = :date")
    suspend fun deleteFixturesByDate(date: String)

    @Query("SELECT * FROM ResponseEntity WHERE date = :date")
    fun getFixturesByDate(date: String): Flow<List<ResponseEntity>>

    @Query("SELECT * FROM ResponseEntity WHERE isFavorite = :favoriteStatus")
    fun getFavoriteFixtures(favoriteStatus: Boolean): Flow<List<ResponseEntity>>
}