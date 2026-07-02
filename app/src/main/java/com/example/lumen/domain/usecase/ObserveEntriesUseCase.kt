package com.example.lumen.domain.usecase

import com.example.lumen.domain.model.MoodEntry
import com.example.lumen.domain.repository.MoodRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveEntriesUseCase @Inject constructor(private val repository: MoodRepository) {
    operator fun invoke(): Flow<List<MoodEntry>> = repository.observeEntries()
}