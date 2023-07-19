package com.nourelden515.gonutswithdonuts

sealed class BottomNavigationScreens(
    val route: String,
    val selectedIcon: Int,
    val notSelectedIcon: Int,
) {
    object Home : BottomNavigationScreens(
        "home",
        R.drawable.icon_home_filled,
        R.drawable.icon_home
    )

    object Profile : BottomNavigationScreens(
        "profile",
        R.drawable.icon_user_filled,
        R.drawable.icon_user
    )

    object Favourites : BottomNavigationScreens(
        "favourites",
        R.drawable.icon_heart_filled,
        R.drawable.icon_heart
    )

    object Notification : BottomNavigationScreens(
        "notification",
        R.drawable.icon_notification_filled,
        R.drawable.icon_notification
    )

    object Cart : BottomNavigationScreens(
        "cart",
        R.drawable.icon_buy_filled,
        R.drawable.icon_buy
    )
}