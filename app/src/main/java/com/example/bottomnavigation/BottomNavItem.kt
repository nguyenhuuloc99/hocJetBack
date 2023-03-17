package com.example.bottomnavigation

sealed class BottomNavItem(var title :String,var icon : Int,var screen_route: String) {
    object Home : BottomNavItem("Home",R.drawable.icon_home,"home")
    object Setting : BottomNavItem("Setting",R.drawable.setting,"setting")
}
