package com.nourelden515.gonutswithdonuts.ui.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.screens.home.OfferUiState
import com.nourelden515.gonutswithdonuts.ui.theme.Black60
import com.nourelden515.gonutswithdonuts.ui.theme.Typography
import com.nourelden515.gonutswithdonuts.ui.theme.White

@Composable
fun OfferItem(
    modifier: Modifier = Modifier,
    offer: OfferUiState
) {
    Box(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(330.dp),
            colors = CardDefaults.cardColors(
                containerColor = offer.color
            ),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier
                        .size(45.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = White
                    ),
                    contentPadding = PaddingValues(0.dp),
                    shape = CircleShape
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.icon_heart),
                        contentDescription = stringResource(id = R.string.content_description),
                        contentScale = ContentScale.Inside
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = offer.title,
                        style = Typography.labelMedium
                    )
                    Text(
                        text = offer.description,
                        style = Typography.bodySmall
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.End)
                            .wrapContentWidth(),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = "\$${offer.realPrice}",
                            style = Typography.bodyLarge,
                            color = Black60,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = "\$${offer.salePrice}",
                            style = Typography.titleSmall,
                            fontSize = 22.sp
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .offset(x = 50.dp, y = 40.dp)
                .align(Alignment.TopEnd),
        ) {
            Image(
                modifier = Modifier.width(170.dp),
                painter = painterResource(id = offer.image),
                contentDescription = stringResource(id = R.string.content_description),
                contentScale = ContentScale.Inside
            )
        }
    }
}