package com.example.lumen.domain.usecase

import com.example.lumen.domain.model.MoodEntry
import com.example.lumen.domain.repository.MoodRepository
import javax.inject.Inject

class SaveMoodEntryUseCase @Inject constructor(private val repository: MoodRepository) {

    suspend operator fun invoke(entry: MoodEntry): Result<Long> {
        if (entry.emotions.isEmpty() && entry.situation.isBlank()) {
            return Result.failure(IllegalArgumentException("Registre ao menos uma emoção ou descreva a situação"))
        }

        return Result.success(repository.saveEntry(entry))
    }

}