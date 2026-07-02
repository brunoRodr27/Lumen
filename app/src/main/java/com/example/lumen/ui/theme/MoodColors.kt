package com.example.lumen.ui.theme

import androidx.compose.ui.graphics.Color
import com.example.lumen.domain.model.MoodLevel

fun MoodLevel.color(): Color =
    when (this) {
        MoodLevel.VERY_POSITIVE -> MoodMuitoPositivo
        MoodLevel.POSITIVE      -> MoodPositivo
        MoodLevel.NEUTRAL       -> MoodNeutro
        MoodLevel.NEGATIVE      -> MoodNegativo
        MoodLevel.VERY_NEGATIVE -> MoodMuitoNegativo}