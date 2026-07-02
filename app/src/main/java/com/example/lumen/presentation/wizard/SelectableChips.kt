package com.example.lumen.presentation.wizard

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lumen.ui.theme.VerdeMusgo

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SelectableChips(
    options: List<String>,
    selected: List<String>,
    onToggle: (String) -> Unit,
    onAddCustom: (String) -> Unit,
    modifier: Modifier = Modifier)
{
    var showAdd by remember { mutableStateOf(false) }
    var custom by remember { mutableStateOf("") }

    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        options.forEach { option ->
            val isSel = option in selected
            FilterChip(
                selected = isSel,
                onClick = { onToggle(option) },
                label = { Text(option) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = VerdeMusgo,
                    selectedLabelColor = Color.White
                )
            )
        }

        AssistChip(
            onClick = { showAdd = true },
            label = { Text("Adicionar") },
            leadingIcon = { Icon(Icons.Default.Add, contentDescription = null) }
        )
    }

    if (showAdd) {
        AlertDialog(
            onDismissRequest = { showAdd = false },
            title = { Text("Adicionar opção") },
            text = {OutlinedTextField(
                value = custom,
                onValueChange = { custom = it },
                label = { Text("Digite o que você sente")}
            )},
            confirmButton = {
                TextButton(
                    onClick = { if (custom.isNotBlank()) onAddCustom(custom.trim())
                        custom = ""; showAdd = false }) { Text("Adicionar") } },
            dismissButton = {
                TextButton(onClick = { showAdd = false }) { Text("Cancelar")}
            }
        )
    }
}