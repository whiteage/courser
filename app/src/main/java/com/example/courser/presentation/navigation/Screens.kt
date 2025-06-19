package com.example.courser.presentation.navigation


sealed class Screens(val route: String ){

    object MainScreen : Screens("Main")
    object Favourite : Screens("Favourite")
    object Login : Screens("Login")
}