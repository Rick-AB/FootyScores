package com.example.footyscores.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footyscores.data.local.entities.ResponseEntity

@Database(
    entities = [ResponseEntity::class],
    version = 1
)
abstract class FootyDatabase : RoomDatabase() {
    abstract val dao: Dao
}