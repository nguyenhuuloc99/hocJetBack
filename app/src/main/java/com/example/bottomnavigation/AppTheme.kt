package com.example.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AppTheme(
    var largerTitle: TextStyle = TextStyle.Default, val title: TextStyle = TextStyle.Default,
    val subTitle: TextStyle = TextStyle.Default, val body: TextStyle = TextStyle.Default
) {

}

val LocalAppTypograopry = staticCompositionLocalOf { AppTheme() }

@Composable
fun AppDemo(content: @Composable () -> Unit) {
    val typography = AppTheme(
        largerTitle = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,

            ),
        title = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,

            ),
        body = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

            ),
        subTitle = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,

            ),

        )
    CompositionLocalProvider(LocalAppTypograopry provides AppTheme()) {
        content.invoke()
    }
}
object AppObjectTheme{
    val appTypography : AppTheme
    @Composable
    get() = LocalAppTypograopry.current

}