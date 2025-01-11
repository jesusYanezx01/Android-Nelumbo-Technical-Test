package com.example.nelumbotechnicaltest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nelumbotechnicaltest.ui.detailRequest.DetailScreen
import com.example.nelumbotechnicaltest.ui.home.HomeScreen
import com.example.nelumbotechnicaltest.ui.login.LoginScreen


@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController, startDestination = Screens.LOGIN.title) {

        composable(Screens.LOGIN.title) { LoginScreen(navController) }

        composable(Screens.HOME.title) { HomeScreen(navController) }

        composable("${Screens.REQUEST_DETAIL.title}/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            DetailScreen(navController, id)
        }
    }
}
