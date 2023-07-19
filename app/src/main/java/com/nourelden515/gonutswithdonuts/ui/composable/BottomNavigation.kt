package com.nourelden515.gonutswithdonuts.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nourelden515.gonutswithdonuts.BottomNavigationScreens
import com.nourelden515.gonutswithdonuts.ui.main.LocalNavigationProvider
import com.nourelden515.gonutswithdonuts.ui.theme.Primary40
import com.nourelden515.gonutswithdonuts.ui.theme.White60

@Composable
fun BottomNavigation(bottomNavState: MutableState<Boolean>) {
    val navController = LocalNavigationProvider.current

    val screens = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Favourites,
        BottomNavigationScreens.Notification,
        BottomNavigationScreens.Cart,
        BottomNavigationScreens.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    AnimatedVisibility(
        visible = bottomNavState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation(
                backgroundColor = White60
            ) {

                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }

        }
    )
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavigationScreens,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    NavigationBarItem(
        icon = {
            if (isSelected) {
                Icon(
                    painter = painterResource(screen.selectedIcon),
                    contentDescription = screen.route
                )
            } else {
                Icon(
                    painter = painterResource(screen.notSelectedIcon),
                    contentDescription = screen.route
                )
            }
        },
        selected = isSelected,
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = White60,
            selectedIconColor = Primary40,
            unselectedIconColor = Primary40
        ),
        onClick = {
            navController.navigate(screen.route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        }
    )
}

