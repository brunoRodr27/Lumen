package com.example.lumen.presentation.wizard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContextStep(
    state: WizardState,
    onUpdate: (situation: String, thought: String, behavior: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = state.situation,
            onValueChange = { onUpdate(it, state.thought, state.behavior) },
            label = { Text("O que aconteceu? (situação)") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2
        )
        OutlinedTextField(
            value = state.thought,
            onValueChange = { onUpdate(state.situation, it, state.behavior) },
            label = { Text("Que pensamentos vieram?") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2
        )
        OutlinedTextField(
            value = state.behavior,
            onValueChange = { onUpdate(state.situation, state.thought, it) },
            label = { Text("Como você reagiu? (comportamento)") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2
        )
    }
}