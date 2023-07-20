package com.nourelden515.gonutswithdonuts.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nourelden515.gonutswithdonuts.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()

    private val args = DonutDetailsArgs(savedStateHandle)

    init {
        getDonutDetailsByTitle()
    }

    private fun getDonutDetailsByTitle() {
        val donut = getDonutsDetails().first { donut -> donut.title == args.donutTitle }
        _state.update {
            it.copy(
                title = donut.title,
                description = donut.description,
                image = donut.image,
                quantity = donut.quantity,
                price = donut.price,
            )
        }
    }

    private fun getDonutsDetails(): List<DetailsUiState> {
        return listOf(
            DetailsUiState(
                title = "Strawberry Wheel",
                description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                image = R.drawable.pink_donut,
                quantity = 1,
                price = "$20"
            ),
            DetailsUiState(
                title = "Chocolate Glaze",
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                image = R.drawable.brown_donut,
                quantity = 1,
                price = "$20"
            ),
            DetailsUiState(
                title = "Chocolate Cherry",
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                image = R.drawable.side_donut1,
                quantity = 1,
                price = "$22"
            ),
            DetailsUiState(
                title = "Strawberry Rain",
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                image = R.drawable.side_donut2,
                quantity = 1,
                price = "$22"
            ),
        )
    }
}