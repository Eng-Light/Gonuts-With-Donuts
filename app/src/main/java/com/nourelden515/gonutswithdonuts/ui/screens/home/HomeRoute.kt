package com.nourelden515.gonutswithdonuts.ui.screens.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "home"

fun NavGraphBuilder.homeRoute() {
    composable(route = ROUTE) {
        HomeScreen()
    }
}