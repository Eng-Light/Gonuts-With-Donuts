package com.nourelden515.gonutswithdonuts.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.main.LocalNavigationProvider
import com.nourelden515.gonutswithdonuts.ui.screens.details.composable.DetailsHeader
import com.nourelden515.gonutswithdonuts.ui.screens.details.composable.Footer
import com.nourelden515.gonutswithdonuts.ui.screens.details.composable.QuantityControl
import com.nourelden515.gonutswithdonuts.ui.theme.Primary40
import com.nourelden515.gonutswithdonuts.ui.theme.Primary80
import com.nourelden515.gonutswithdonuts.ui.theme.Typography
import com.nourelden515.gonutswithdonuts.ui.theme.White

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavigationProvider.current

    DetailsContent(
        state = state,
        onClickExit = { navController.navigateUp() }
    )
}

@Composable
fun DetailsContent(
    state: DetailsUiState,
    onClickExit: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary80)
    ) {
        Box(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
        ) {
            DetailsHeader(donutState = state, onClickExit = onClickExit)
        }

        Box(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(color = White)
                    .padding(top = 40.dp, start = 40.dp, end = 40.dp, bottom = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = state.title, style = Typography.titleMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(R.string.about_gonut), style = Typography.labelLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = state.description, style = Typography.bodySmall)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(R.string.quantity), style = Typography.labelLarge)
                QuantityControl(
                    donutState = state,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(modifier = Modifier.weight(1F))
                Footer(donutState = state)
            }

            IconButton(
                modifier = Modifier
                    .offset(y = (-24).dp)
                    .padding(end = 16.dp)
                    .size(45.dp)
                    .background(color = White, shape = RoundedCornerShape(10.dp))
                    .align(alignment = Alignment.TopEnd),
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.icon_favorite),
                    contentDescription = stringResource(R.string.content_description),
                    tint = Primary40
                )
            }
        }
    }
}