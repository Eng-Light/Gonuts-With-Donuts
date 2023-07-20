package com.nourelden515.gonutswithdonuts.ui.screens.details.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.composable.CustomButton
import com.nourelden515.gonutswithdonuts.ui.screens.details.DetailsUiState
import com.nourelden515.gonutswithdonuts.ui.theme.Black
import com.nourelden515.gonutswithdonuts.ui.theme.Typography

@Composable
fun Footer(
    donutState: DetailsUiState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = donutState.price,
            style = Typography.titleMedium,
            color = Black
        )
        CustomButton(
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            onClick = { }, text = stringResource(R.string.add_to_cart)
        )
    }
}