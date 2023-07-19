package com.nourelden515.gonutswithdonuts.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nourelden515.gonutswithdonuts.BottomNavigationScreens
import com.nourelden515.gonutswithdonuts.GonutsWithDonutsNavGraph
import com.nourelden515.gonutswithdonuts.ui.composable.BottomNavigation
import com.nourelden515.gonutswithdonuts.ui.theme.GonutsWithDonutsTheme
import com.nourelden515.gonutswithdonuts.ui.theme.White60
import dagger.hilt.android.AndroidEntryPoint

val LocalNavigationProvider = staticCompositionLocalOf<NavHostController> {
    error("No navigation host controller provided.")
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {
                GonutsWithDonutsTheme {
                    val bottomNavState = checkBottomBarState()
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(White60),
                        bottomBar = {
                            BottomNavigation(bottomNavState = bottomNavState)
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)){
                            GonutsWithDonutsNavGraph()
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun checkBottomBarState(): MutableState<Boolean> {
        val navController = LocalNavigationProvider.current
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

        val bottomBarScreens = listOf(
            BottomNavigationScreens.Home.route,
            BottomNavigationScreens.Favourites.route,
            BottomNavigationScreens.Notification.route,
            BottomNavigationScreens.Cart.route,
            BottomNavigationScreens.Profile.route
        )

        when (navBackStackEntry?.destination?.route) {
            in bottomBarScreens -> {
                // Show BottomBar
                bottomBarState.value = true
            }

            else -> {
                // Hide BottomBar
                bottomBarState.value = false
            }
        }
        return bottomBarState
    }
}