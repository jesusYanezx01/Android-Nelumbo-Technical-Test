package com.example.nelumbotechnicaltest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nelumbotechnicaltest.ui.Detail.DetailScreen
import com.example.nelumbotechnicaltest.ui.home.HomeScreen
import com.example.nelumbotechnicaltest.ui.login.LoginScreen
import com.example.nelumbotechnicaltest.ui.theme.NelumboTechnicalTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NelumboTechnicalTestTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { LoginScreen(navController) }
                    composable("home") { HomeScreen(navController) }
                    composable("detail") { DetailScreen(navController) }
                }
            }
        }
    }
}