package catsOfClaire.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Material typography styles
val typography = Typography(

    // Need to add fonts for the better text styling

    h3 = TextStyle(
        fontWeight = FontWeight.W800,
        fontSize = 32.sp
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 32.sp
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontSize = 14.sp
    ),
)
