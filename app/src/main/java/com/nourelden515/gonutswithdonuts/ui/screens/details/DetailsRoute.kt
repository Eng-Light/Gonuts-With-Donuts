package com.nourelden515.gonutswithdonuts.ui.screens.details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "details"

fun NavGraphBuilder.detailsRoute() {
    composable(route = ROUTE) {
        DetailsScreen()
    }
}