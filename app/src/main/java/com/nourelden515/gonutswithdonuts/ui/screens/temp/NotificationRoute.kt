package com.nourelden515.gonutswithdonuts.ui.screens.temp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "notification"

fun NavGraphBuilder.notificationRoute() {
    composable(route = ROUTE) {
        TempScreen()
    }
}