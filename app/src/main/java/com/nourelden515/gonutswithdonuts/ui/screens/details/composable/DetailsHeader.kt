package com.nourelden515.gonutswithdonuts.ui.screens.details.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.screens.details.DetailsUiState
import com.nourelden515.gonutswithdonuts.ui.theme.Primary40

@Composable
fun DetailsHeader(
    donutState: DetailsUiState,
    modifier: Modifier = Modifier,
    onClickExit: () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxSize()
    ) {
        IconButton(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .size(40.dp),
            onClick = onClickExit
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.icon_back),
                contentDescription = stringResource(R.string.content_description),
                tint = Primary40
            )
        }

        Image(
            painter = rememberAsyncImagePainter(donutState.image),
            contentDescription = donutState.title,
            modifier = Modifier
                .aspectRatio(1F)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
    }
}