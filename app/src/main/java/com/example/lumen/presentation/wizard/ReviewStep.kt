package com.example.lumen.presentation.wizard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReviewStep(
    state: WizardState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ReviewRow("Humor", state.mood?.label ?: "—")
        ReviewRow("Emoções", state.emotions.joinToString().ifBlank { "—" })
        ReviewRow("Sensações", state.sensations.joinToString().ifBlank { "—" })
        ReviewRow("Situação", state.situation.ifBlank { "—" })
        ReviewRow("Pensamentos", state.thought.ifBlank { "—" })
        ReviewRow("Comportamento", state.behavior.ifBlank { "—" })
    }
}

@Composable
private fun ReviewRow(label: String, value: String) {
    Column {
        Text(label, style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, style = MaterialTheme.typography.bodyLarge)
    }
}