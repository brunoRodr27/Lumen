package com.example.lumen.presentation.wizard

import com.example.lumen.domain.model.MoodLevel

data class WizardState(
    val step: WizardStep = WizardStep.MOOD,
    val mood: MoodLevel? = null,
    val emotions: List<String> = emptyList(),
    val sensations: List<String> = emptyList(),
    val situation: String = "",
    val thought: String = "",
    val behavior: String = "",
    val isSaving: Boolean = false,
    val savedId: Long? = null,
    val error: String? = null)
{
    val canAdvance: Boolean get() =
        when (step) {
            WizardStep.MOOD -> mood != null
            else -> true    }
}