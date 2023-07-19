package com.nourelden515.gonutswithdonuts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.nourelden515.gonutswithdonuts.ui.main.LocalNavigationProvider
import com.nourelden515.gonutswithdonuts.ui.screens.details.detailsRoute
import com.nourelden515.gonutswithdonuts.ui.screens.home.homeRoute
import com.nourelden515.gonutswithdonuts.ui.screens.onboarding.onBoardingRoute
import com.nourelden515.gonutswithdonuts.ui.screens.temp.cartRoute
import com.nourelden515.gonutswithdonuts.ui.screens.temp.favouritesRoute
import com.nourelden515.gonutswithdonuts.ui.screens.temp.notificationRoute
import com.nourelden515.gonutswithdonuts.ui.screens.temp.profileRoute

@Composable
fun GonutsWithDonutsNavGraph() {
    val navController = LocalNavigationProvider.current

    NavHost(navController = navController, startDestination = "onBoarding") {
        onBoardingRoute()
        homeRoute()
        detailsRoute()
        favouritesRoute()
        notificationRoute()
        cartRoute()
        profileRoute()
    }
}