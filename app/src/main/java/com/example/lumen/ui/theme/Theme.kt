package com.example.lumen.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = Terracota,
    onPrimary = AreiaCard,
    secondary = VerdeMusgo,
    onSecondary = AreiaCard,
    background = Areia,
    onBackground = Cafe,
    surface = AreiaCard,
    onSurface = Cafe,
    surfaceVariant = Areia,
    onSurfaceVariant = CafeSuave,
    outline = Bordas)

private val DarkColors = darkColorScheme(
    primary = Terracota,
    onPrimary = AreiaCard,
    secondary = MoodPositivo,
    background = AreiaDark,
    onBackground = TextoDark,
    surface = CardDark,
    onSurface = TextoDark,
    outline = BordasDark)

@Composable
fun LumenTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit) {

    val colorScheme =
        when { dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
            darkTheme -> DarkColors
            else -> LightColors}

    MaterialTheme(
        colorScheme = colorScheme,
        typography = LumenTypography,
        shapes = LumenShapes,
        content = content    )
}