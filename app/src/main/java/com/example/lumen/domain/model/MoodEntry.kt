package com.example.lumen.domain.model

import com.lumen.app.domain.model.MoodLevel

data class MoodEntry(
    val id: Long = 0,
    val createdAt: Long,
    val mood: MoodLevel,
    val emotions: List<String>,
    val sensations: List<String>,
    val situation: String,
    val thought: String,
    val behavior: String
)