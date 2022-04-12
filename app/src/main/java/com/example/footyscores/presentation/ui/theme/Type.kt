package com.example.footyscores.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.footyscores.R

// Set of Material typography styles to start with
private val LatoFontFamily = FontFamily(
    Font(R.font.lato_regular, FontWeight.Normal),
    Font(R.font.lato_bold, FontWeight.Bold),
    Font(R.font.lato_heavy, FontWeight.ExtraBold),
    Font(R.font.lato_black, FontWeight.Black),
    Font(R.font.lato_light, FontWeight.Light),
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = LatoFont.fontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = LatoFont.fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val LatoFont = TextStyle(
    fontFamily = LatoFontFamily
)