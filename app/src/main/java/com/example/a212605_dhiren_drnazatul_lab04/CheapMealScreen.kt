package com.example.a212605_dhiren_drnazatul_lab04

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a212605_dhiren_drnazatul_lab04.model.CheapMealViewModel
import com.example.a212605_dhiren_drnazatul_lab04.ui.DealsScreen
import com.example.a212605_dhiren_drnazatul_lab04.ui.HomeScreen
import com.example.a212605_dhiren_drnazatul_lab04.ui.ProfileScreen
import com.example.a212605_dhiren_drnazatul_lab04.ui.ProfileSetupScreen

sealed class Screen(val route: String) {
    object Home         : Screen("home")
    object Deals        : Screen("deals")
    object ProfileSetup : Screen("profile_setup")
    object Profile      : Screen("profile")
}

@Composable
fun CheapMealApp() {
    val navController = rememberNavController()
    val viewModel = viewModel<CheapMealViewModel>()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.Deals.route) {
            DealsScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.ProfileSetup.route) {
            ProfileSetupScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController, viewModel = viewModel)
        }
    }
}
