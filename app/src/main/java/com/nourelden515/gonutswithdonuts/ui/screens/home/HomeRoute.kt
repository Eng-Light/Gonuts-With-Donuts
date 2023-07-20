package com.nourelden515.gonutswithdonuts.ui.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "home"

fun NavController.navigateToHome() {
    navigate(ROUTE)
}
fun NavGraphBuilder.homeRoute() {
    composable(route = ROUTE) {
        HomeScreen()
    }
}