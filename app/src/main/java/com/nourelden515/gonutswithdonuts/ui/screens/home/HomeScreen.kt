package com.nourelden515.gonutswithdonuts.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.main.LocalNavigationProvider
import com.nourelden515.gonutswithdonuts.ui.screens.details.navigateToDetails
import com.nourelden515.gonutswithdonuts.ui.screens.home.composable.DonutItem
import com.nourelden515.gonutswithdonuts.ui.screens.home.composable.OfferItem
import com.nourelden515.gonutswithdonuts.ui.screens.home.composable.SearchHeader
import com.nourelden515.gonutswithdonuts.ui.theme.Typography
import com.nourelden515.gonutswithdonuts.ui.theme.White60

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val navController = LocalNavigationProvider.current
    val state = viewModel.state.collectAsState()
    HomeContent(
        onClickDonut = {
            navController.navigateToDetails()
        },
        state = state
    )
}

@Composable
fun HomeContent(
    state: State<HomeUiState>,
    onClickDonut: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(White60)
            .fillMaxSize()
            .padding(top = 80.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SearchHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        )
        Text(
            modifier = Modifier
                .padding(start = 32.dp, top = 42.dp),
            text = stringResource(R.string.today_offers),
            style = Typography.titleSmall
        )
        LazyRow(
            modifier = Modifier
                .padding(vertical = 8.dp),
            contentPadding = PaddingValues(
                horizontal = 24.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            itemsIndexed(state.value.offers) { _, offer ->
                OfferItem(
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { onClickDonut() },
                    offer = offer
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp),
            text = stringResource(R.string.donuts),
            style = Typography.titleSmall
        )
        LazyRow(
            modifier = Modifier
                .padding(vertical = 18.dp),
            contentPadding = PaddingValues(
                horizontal = 24.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            itemsIndexed(state.value.donuts) { _, donut ->
                DonutItem(
                    donut = donut,
                    modifier = Modifier
                        .padding(top = 42.dp)
                        .clickable { onClickDonut() }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}