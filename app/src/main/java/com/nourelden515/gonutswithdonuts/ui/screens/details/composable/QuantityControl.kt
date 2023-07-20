package com.nourelden515.gonutswithdonuts.ui.screens.details.composable


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.screens.details.DetailsUiState
import com.nourelden515.gonutswithdonuts.ui.theme.Black
import com.nourelden515.gonutswithdonuts.ui.theme.Typography
import com.nourelden515.gonutswithdonuts.ui.theme.White

@Composable
fun QuantityControl(
    donutState: DetailsUiState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier
                .padding(end = 20.dp)
                .background(color = White, shape = RoundedCornerShape(8.dp))
                .size(45.dp),
            onClick = {}
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.icon_minus),
                contentDescription = stringResource(R.string.content_description),
            )
        }
        Box(
            modifier = Modifier
                .background(color = White, shape = RoundedCornerShape(8.dp))
                .size(45.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = donutState.quantity.toString(),
                style = Typography.labelMedium,
                modifier = Modifier.align(Alignment.Center),
                fontSize = 22.sp
            )
        }
        IconButton(
            modifier = Modifier
                .padding(start = 20.dp)
                .background(color = Black, shape = RoundedCornerShape(8.dp))
                .size(45.dp),
            onClick = {}
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.icon_plus),
                contentDescription = stringResource(R.string.content_description),
                tint = White
            )
        }
    }
}