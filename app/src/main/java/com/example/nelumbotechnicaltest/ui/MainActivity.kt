package com.example.nelumbotechnicaltest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nelumbotechnicaltest.ui.navigation.AppNavigation
import com.example.nelumbotechnicaltest.ui.theme.NelumboTechnicalTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NelumboTechnicalTestTheme {
                AppNavigation()
            }
        }
    }
}
