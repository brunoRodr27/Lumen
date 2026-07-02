package com.example.lumen.domain.repository

import com.example.lumen.data.local.MoodDao
import com.example.lumen.data.mapper.toDomain
import com.example.lumen.data.mapper.toEntity
import com.example.lumen.domain.model.MoodEntry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MoodRepositoryImpl @Inject constructor(private val dao: MoodDao) : MoodRepository {
    override fun observeEntries(): Flow<List<MoodEntry>> = dao.observeAll().map { list -> list.map { it.toDomain() } }

    override suspend fun getEntry(id: Long): MoodEntry? = dao.getById(id)?.toDomain()

    override suspend fun saveEntry(entry: MoodEntry): Long = dao.insert(entry.toEntity())

    override suspend fun deleteEntry(entry: MoodEntry) = dao.delete(entry.toEntity())
}