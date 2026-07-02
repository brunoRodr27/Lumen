package com.example.lumen.data.repository

import com.example.lumen.BuildConfig
import com.example.lumen.core.Resource
import com.example.lumen.data.remote.*
import com.example.lumen.domain.model.MoodEntry
import com.example.lumen.domain.repository.SummaryRepository
import javax.inject.Inject

class SummaryRepositoryImpl @Inject constructor(private val api: SummaryApi) : SummaryRepository {

    override fun isAvailable(): Boolean = BuildConfig.SUMMARY_API_KEY.isNotBlank()

    override suspend fun weeklySummary(entries: List<MoodEntry>): Resource<String> {
        if (!isAvailable()) return Resource.Error("IA não configurada")
        return try {
            val prompt = buildPrompt(entries)
            val response = api.summarize(authHeader = "Bearer ${BuildConfig.SUMMARY_API_KEY}",
                                         request = SummaryRequest(model = "gpt-4o-mini",
                                                                  messages = listOf(Message("user", prompt))))
            Resource.Success(response.choices.first().message.content)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Falha ao gerar resumo")
        }
    }

    private fun buildPrompt(entries: List<MoodEntry>): String = buildString {
        appendLine("Resuma com empatia os padrões emocionais desta semana.")
        appendLine("Destaque emoções e situações recorrentes. Português, 1 parágrafo.")
        entries.forEach { e -> appendLine("- ${e.mood.label}; emoções: ${e.emotions.joinToString()}; " + "situação: ${e.situation}")}
    }

}