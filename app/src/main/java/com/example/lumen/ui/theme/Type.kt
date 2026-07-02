package com.example.lumen.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.lumen.R

val Family = FontFamily(Font(R.font.nunito_regular))

val LumenTypography = Typography(

    headlineMedium = TextStyle(
        fontFamily = Family,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp),

    titleLarge = TextStyle(
        fontFamily = Family,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp),

    bodyLarge = TextStyle(
        fontFamily = Family,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp),

    labelSmall = TextStyle(
        fontFamily = Family,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp)
)