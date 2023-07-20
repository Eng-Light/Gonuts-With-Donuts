package com.nourelden515.gonutswithdonuts.ui.screens.home

import androidx.lifecycle.ViewModel
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.theme.BabyBlue
import com.nourelden515.gonutswithdonuts.ui.theme.Primary80
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getOffers()
        getDonuts()
    }

    private fun getDonuts() {
        _state.update {
            it.copy(
                donuts = listOf(
                    DonutUiState(
                        image = R.drawable.side_donut1,
                        title = "Chocolate Cherry",
                        price = 22
                    ),
                    DonutUiState(
                        image = R.drawable.side_donut2,
                        title = "Strawberry Rain",
                        price = 22
                    ),
                    DonutUiState(
                        image = R.drawable.side_donut1,
                        title = "Chocolate Cherry",
                        price = 22
                    ),
                    DonutUiState(
                        image = R.drawable.side_donut2,
                        title = "Strawberry Rain",
                        price = 22
                    )
                )
            )
        }
    }

    private fun getOffers() {
        _state.update {
            it.copy(
                offers = listOf(
                    OfferUiState(
                        title = "Strawberry Wheel",
                        description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                        image = R.drawable.pink_donut,
                        isFavorite = false,
                        realPrice = "20",
                        salePrice = "16",
                        color = BabyBlue
                    ), OfferUiState(
                        title = "Chocolate Glaze",
                        description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                        image = R.drawable.brown_donut,
                        isFavorite = false,
                        realPrice = "20",
                        salePrice = "16",
                        color = Primary80
                    ),
                    OfferUiState(
                        title = "Strawberry Wheel",
                        description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                        image = R.drawable.pink_donut,
                        isFavorite = false,
                        realPrice = "20",
                        salePrice = "16",
                        color = BabyBlue
                    ), OfferUiState(
                        title = "Chocolate Glaze",
                        description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                        image = R.drawable.brown_donut,
                        isFavorite = false,
                        realPrice = "20",
                        salePrice = "16",
                        color = Primary80
                    )
                )
            )
        }
    }
}
