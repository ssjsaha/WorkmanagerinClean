package com.example.workmanagerinclean.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ROUTE_MAIN") {
        navigation(
            startDestination = "ROUTE_START", route = "ROUTE_MAIN"
        ) {

            composable(route = "ROUTE_START") {
                val viewModel: PostViewModel = hiltViewModel()
                MainPage(viewModel::onEvent)
            }
        }
    }
}
