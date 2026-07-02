package com.example.lumen.presentation.wizard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.lumen.domain.model.MoodLevel
import com.example.lumen.ui.theme.color

@Composable
fun MoodStep(
    selected: MoodLevel?,
    onSelect: (MoodLevel) -> Unit,
    modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        MoodLevel.entries.forEach { level ->
            val isSelected = level == selected

            Card(
                onClick = { onSelect(level) },
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected)
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                    else MaterialTheme.colorScheme.surface
                )
            ) {
                Row(
                    Modifier.padding(16.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        Modifier.size(width = 5.dp, height = 26.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(level.color())
                    )

                    Spacer(Modifier.width(14.dp))

                    Text(level.label, style = MaterialTheme.typography.titleLarge)
                }
            }
        }
    }
}