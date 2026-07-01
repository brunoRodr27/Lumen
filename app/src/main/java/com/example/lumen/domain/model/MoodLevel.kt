package com.example.lumen.domain.model

enum class MoodLevel(val score: Int, val label: String) {
    VERY_POSITIVE(2, "Muito positivo"),
    POSITIVE(1, "Positivo"),
    NEUTRAL(0, "Neutro"),
    NEGATIVE(-1, "Negativo"),
    VERY_NEGATIVE(-2, "Muito negativo");

    companion object {
        fun fromScore(score: Int): MoodLevel = entries.firstOrNull { it.score == score } ?: NEUTRAL
    }

}