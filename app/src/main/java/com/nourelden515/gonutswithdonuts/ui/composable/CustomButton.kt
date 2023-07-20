package com.nourelden515.gonutswithdonuts.ui.composable

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nourelden515.gonutswithdonuts.ui.theme.Primary40
import com.nourelden515.gonutswithdonuts.ui.theme.Typography
import com.nourelden515.gonutswithdonuts.ui.theme.White

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonColor: Color = Primary40,
    text: String,
    textColor: Color = White,
) {
    Button(
        modifier = modifier.height(56.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(buttonColor),
    ) {
        Text(
            text = text,
            color = textColor,
            style = Typography.titleSmall,
        )
    }
}