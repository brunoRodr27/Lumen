package com.example.lumen.presentation.wizard

enum class WizardStep(val index: Int, val title: String) {
    MOOD(0, "Como está seu humor?"),
    EMOTIONS(1, "O que você está sentindo?"),
    SENSATIONS(2, "Como seu corpo reagiu?"),
    CONTEXT(3, "O que aconteceu?"),
    REVIEW(4, "Revisar e salvar");

    val isFirst get() = index == 0
    val isLast get() = index == entries.size - 1

    fun next() = entries.getOrElse(index + 1) { this }
    fun previous() = entries.getOrElse(index - 1) { this }
}