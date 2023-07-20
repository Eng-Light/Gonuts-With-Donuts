package com.nourelden515.gonutswithdonuts.ui.screens.home

import androidx.compose.ui.graphics.Color
import com.nourelden515.gonutswithdonuts.ui.theme.BabyBlue

data class HomeUiState(
    val offers: List<OfferUiState> = emptyList(),
    val donuts: List<DonutUiState> = emptyList(),
)

data class OfferUiState(
    val title: String = "Strawberry Wheel",
    val description: String = "These Baked Strawberry Donuts are filled with fresh strawberries...",
    val image: Int = 0,
    val isFavorite: Boolean = false,
    val realPrice: String = "20",
    val salePrice: String = "16",
    val color: Color = BabyBlue,
)

data class DonutUiState(
    val image: Int = 0,
    val title: String = "",
    val price: Int = 0,
)