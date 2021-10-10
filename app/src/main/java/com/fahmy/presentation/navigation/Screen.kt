package com.fahmy.presentation.navigation

sealed class Screen(val route: String) {
    object Cities : Screen("city")

}
