package com.example.lumen.domain.repository

import com.example.lumen.core.Resource
import com.example.lumen.domain.model.MoodEntry

interface SummaryRepository {

    fun isAvailable(): Boolean

    suspend fun weeklySummary(entries: List<MoodEntry>): Resource<String>
}