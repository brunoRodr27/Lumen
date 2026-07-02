package com.example.lumen.domain.repository

import com.example.lumen.domain.model.MoodEntry
import kotlinx.coroutines.flow.Flow

interface MoodRepository {
    fun observeEntries(): Flow<List<MoodEntry>>

    suspend fun getEntry(id: Long): MoodEntry?

    suspend fun saveEntry(entry: MoodEntry): Long

    suspend fun deleteEntry(entry: MoodEntry)
}