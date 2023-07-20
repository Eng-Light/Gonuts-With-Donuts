package com.nourelden515.gonutswithdonuts.ui.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.screens.home.DonutUiState
import com.nourelden515.gonutswithdonuts.ui.theme.Primary40
import com.nourelden515.gonutswithdonuts.ui.theme.Typography
import com.nourelden515.gonutswithdonuts.ui.theme.White

@Composable
fun DonutItem(
    donut: DonutUiState,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(
                containerColor = White
            ),
            shape = RoundedCornerShape(
                topStart = 18.dp,
                topEnd = 18.dp,
                bottomEnd = 8.dp,
                bottomStart = 8.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, bottom = 18.dp, start = 8.dp, end = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier,
                    text = donut.title,
                    style = Typography.labelSmall
                )
                Text(
                    modifier = Modifier,
                    text = "\$${donut.price}",
                    style = Typography.labelSmall,
                    color = Primary40
                )
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter),
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .offset(y = (-50).dp),
                painter = painterResource(id = donut.image),
                contentDescription = stringResource(id = R.string.content_description),
                contentScale = ContentScale.Inside
            )
        }
    }
}