package com.nourelden515.gonutswithdonuts.ui.screens.details

import com.nourelden515.gonutswithdonuts.R

data class DetailsUiState(
    val title: String = "",
    val image: Int = R.drawable.pink_donut,
    val description: String = "",
    val quantity: Int = 0,
    val price: String = "",
)