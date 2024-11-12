package com.example.pb_jm_comp304sec003_lab03.Navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pb_jm_comp304sec003_lab03.viewmodels.WeatherDataViewModel
import com.example.pb_jm_comp304sec003_lab03.views.screens.HomeScreen
import com.example.pb_jm_comp304sec003_lab03.views.screens.SearchScreen


@Composable
fun NavGraph(navHostController: NavHostController, viewModel: WeatherDataViewModel)
{
    NavHost(navController = navHostController, startDestination = NavDestination.HomeScreen.route)
    {
        composable(NavDestination.HomeScreen.route) { HomeScreen(navHostController, viewModel) }
        composable(NavDestination.SearchScreen.route) { SearchScreen(navHostController, viewModel) }
    }
}