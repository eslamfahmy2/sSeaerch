package com.fahmy.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fahmy.presentation.ui.city.component.CityScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Cities.route) {

        composable(route = Screen.Cities.route) {
            CityScreen(viewModel = hiltViewModel())
        }

    }

}