package com.nourelden515.gonutswithdonuts.ui.screens.temp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nourelden515.gonutswithdonuts.ui.screens.onboarding.OnBoardingScreen

private const val ROUTE = "favourites"

fun NavGraphBuilder.favouritesRoute() {
    composable(route = ROUTE) {
        OnBoardingScreen()
    }
}