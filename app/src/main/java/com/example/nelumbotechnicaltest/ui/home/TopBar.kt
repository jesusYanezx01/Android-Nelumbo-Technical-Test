package com.example.nelumbotechnicaltest.ui.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Todas las tiendas",
                style = MaterialTheme.typography.titleMedium,
            )
        },
        modifier = Modifier
            .fillMaxWidth(),
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Store,
                contentDescription = "Tiendas"
            )
        },
        actions = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Navegar a todas las tiendas"
            )
        }
    )
}
