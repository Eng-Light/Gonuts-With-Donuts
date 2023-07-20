package com.nourelden515.gonutswithdonuts.ui.screens.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "details"

fun NavController.navigateToDetails(donutTitle: String) {
    navigate("$ROUTE/$donutTitle")
}

fun NavGraphBuilder.detailsRoute() {
    composable(
        route = "$ROUTE/{${DonutDetailsArgs.DONUT_TITLE}}",
        arguments = listOf(
            navArgument(DonutDetailsArgs.DONUT_TITLE) { NavType.StringType }
        )
    ) {
        DetailsScreen()
    }
}