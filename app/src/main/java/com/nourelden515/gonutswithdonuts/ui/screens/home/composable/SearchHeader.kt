package com.nourelden515.gonutswithdonuts.ui.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.theme.Primary80
import com.nourelden515.gonutswithdonuts.ui.theme.Typography

@Composable
fun SearchHeader(
    modifier: Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = stringResource(R.string.let_s_gonuts),
                style = Typography.titleMedium
            )
            Text(
                text = stringResource(R.string.order_your_favourite_donuts_from_here),
                style = Typography.labelSmall
            )
        }
        Button(
            modifier = Modifier.size(45.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary80
            ),
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = stringResource(id = R.string.content_description),
                contentScale = ContentScale.Inside
            )
        }
    }
}