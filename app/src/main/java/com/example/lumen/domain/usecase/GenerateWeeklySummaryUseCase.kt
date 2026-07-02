package com.example.lumen.domain.usecase

import com.example.lumen.core.Resource
import com.example.lumen.domain.model.MoodEntry
import com.example.lumen.domain.repository.SummaryRepository
import javax.inject.Inject

class GenerateWeeklySummaryUseCase @Inject constructor(private val repository: SummaryRepository) {
    fun isAvailable() = repository.isAvailable()    

    suspend operator fun invoke(entries: List<MoodEntry>): Resource<String> = repository.weeklySummary(entries)
}