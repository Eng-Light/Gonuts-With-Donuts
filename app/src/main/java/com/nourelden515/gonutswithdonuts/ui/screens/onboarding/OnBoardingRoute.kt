package com.nourelden515.gonutswithdonuts.ui.screens.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "onBoarding"

fun NavGraphBuilder.onBoardingRoute() {
    composable(route = ROUTE) {
        OnBoardingScreen()
    }
}