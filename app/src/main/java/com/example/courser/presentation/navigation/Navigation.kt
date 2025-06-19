package com.example.courser.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.courser.presentation.MainVM
import com.example.courser.presentation.screens.FavouriteScreen
import com.example.courser.presentation.screens.LoginScreen
import com.example.courser.presentation.screens.MainScreen

@Composable
fun Navigation(viewModel : MainVM){
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Screens.Login.route){
        composable(Screens.MainScreen.route){
            MainScreen(viewModel, navHostController)
        }
        composable(Screens.Login.route) {
            LoginScreen(viewModel, navHostController)
        }

        composable(Screens.Favourite.route) {
            FavouriteScreen(navHostController,viewModel)

        }

    }
}