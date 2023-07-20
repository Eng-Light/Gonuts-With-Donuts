package com.nourelden515.gonutswithdonuts.ui.screens.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "details"

fun NavController.navigateToDetails() {
    navigate(ROUTE)
}

fun NavGraphBuilder.detailsRoute() {
    composable(route = ROUTE) {
        DetailsScreen()
    }
}