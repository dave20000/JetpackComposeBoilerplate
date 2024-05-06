package com.example.notz.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.notz.R

object AppFontFamily {
    val poppins = FontFamily(
        fonts = listOf(
            Font(R.font.poppins_black, FontWeight.Black, FontStyle.Normal),
            Font(R.font.poppins_black_italic, FontWeight.Black, FontStyle.Italic),
            Font(R.font.poppins_bold, FontWeight.Bold, FontStyle.Normal),
            Font(R.font.poppins_bold_italic, FontWeight.Bold, FontStyle.Italic),
            Font(R.font.poppins_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
            Font(R.font.poppins_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
            Font(R.font.poppins_extra_light, FontWeight.ExtraLight, FontStyle.Normal),
            Font(R.font.poppins_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),
            Font(R.font.poppins_italic, FontWeight.Black, FontStyle.Italic),
            Font(R.font.poppins_light, FontWeight.Light, FontStyle.Normal),
            Font(R.font.poppins_light_italic, FontWeight.Light, FontStyle.Italic),
            Font(R.font.poppins_medium, FontWeight.Medium, FontStyle.Normal),
            Font(R.font.poppins_medium_italic, FontWeight.Medium, FontStyle.Italic),
            Font(R.font.poppins_regular, FontWeight.Normal, FontStyle.Normal),
            Font(R.font.poppins_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
            Font(R.font.poppins_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
            Font(R.font.poppins_thin, FontWeight.Thin, FontStyle.Normal),
            Font(R.font.poppins_thin_italic, FontWeight.Thin, FontStyle.Italic),
        )
    )
}

// Set of Material typography styles to start with
private val defaultTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = AppFontFamily.poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = AppFontFamily.poppins),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = AppFontFamily.poppins),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = AppFontFamily.poppins),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFontFamily.poppins),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = AppFontFamily.poppins),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = AppFontFamily.poppins),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = AppFontFamily.poppins),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = AppFontFamily.poppins),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = AppFontFamily.poppins),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = AppFontFamily.poppins),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = AppFontFamily.poppins),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = AppFontFamily.poppins),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = AppFontFamily.poppins),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = AppFontFamily.poppins),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = AppFontFamily.poppins),
)
