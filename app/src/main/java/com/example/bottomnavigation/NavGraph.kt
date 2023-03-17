package com.example.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottomnavigation.ui.screen.HomeScreen
import com.example.bottomnavigation.ui.screen.SettingScreen

@Composable
fun NavigationGraph(navController : NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Setting.screen_route) {
            SettingScreen()
        }
    }
}