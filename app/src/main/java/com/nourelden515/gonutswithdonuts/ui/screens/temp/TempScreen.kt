package com.nourelden515.gonutswithdonuts.ui.screens.temp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nourelden515.gonutswithdonuts.ui.theme.Typography

@Composable
fun TempScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Temp Screen", style = Typography.titleLarge)
    }
}