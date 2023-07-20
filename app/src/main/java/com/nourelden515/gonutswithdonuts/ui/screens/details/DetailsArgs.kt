package com.nourelden515.gonutswithdonuts.ui.screens.details

import androidx.lifecycle.SavedStateHandle

class DonutDetailsArgs(savedStateHandle: SavedStateHandle) {

    val donutTitle: String = checkNotNull(savedStateHandle[DONUT_TITLE])

    companion object {
        const val DONUT_TITLE = "donut_title"
    }
}