package com.example.lumen.presentation.wizard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.lumen.domain.model.EmotionCatalog
import com.example.lumen.domain.model.SensationCatalog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WizardScreen(
    onSaved: (Long) -> Unit,
    onBack: () -> Unit,
    viewModel: WizardViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.savedId) {state.savedId?.let(onSaved)}

    Scaffold(
        topBar = {TopAppBar(title = { Text(state.step.title) })},
        bottomBar = {Row(Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            if (!state.step.isFirst) {
                OutlinedButton(onClick = viewModel::previous) { Text("Voltar") }
            } else Spacer(Modifier.width(1.dp))

            if (state.step.isLast) {
                Button(onClick = viewModel::save, enabled = !state.isSaving) {
                    Text(if (state.isSaving) "Salvando..." else "Salvar")
                }
            } else {
                Button(onClick = viewModel::next, enabled = state.canAdvance) {
                    Text("Próximo")
                }
            }
        }
        }
    ) { padding -> Column(
        Modifier.padding(padding)
            .padding(16.dp)) {
        LinearProgressIndicator(
            progress = { (state.step.index + 1) / 5f },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(24.dp))

        when (state.step) {
            WizardStep.MOOD -> MoodStep(state.mood, viewModel::selectMood)
            WizardStep.EMOTIONS ->  SelectableChips(EmotionCatalog.suggestions, state.emotions,
                onToggle = viewModel::toggleEmotion,
                onAddCustom = viewModel::toggleEmotion)
            WizardStep.SENSATIONS -> SelectableChips(SensationCatalog.suggestions, state.sensations,
                onToggle = viewModel::toggleSensation,
                onAddCustom = viewModel::toggleSensation)
            WizardStep.CONTEXT -> ContextStep(state, viewModel::updateContext)
            WizardStep.REVIEW -> ReviewStep(state)
        }
    }
    }
}