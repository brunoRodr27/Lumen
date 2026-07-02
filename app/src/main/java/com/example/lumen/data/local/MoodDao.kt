package com.example.lumen.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MoodDao {
    @Query("SELECT * FROM mood_entries ORDER BY createdAt DESC")
    fun observeAll(): Flow<List<MoodEntryEntity>>

    @Query("SELECT * FROM mood_entries WHERE id = :id")
    suspend fun getById(id: Long): MoodEntryEntity?

    @Insert
    suspend fun insert(entry: MoodEntryEntity): Long

    @Delete
    suspend fun delete(entry: MoodEntryEntity)
}