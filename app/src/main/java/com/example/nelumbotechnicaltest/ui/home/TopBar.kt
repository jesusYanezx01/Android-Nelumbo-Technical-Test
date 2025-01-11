package com.example.nelumbotechnicaltest.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.nelumbotechnicaltest.ui.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    TopAppBar(
        title = {
            if (currentRoute.startsWith(Screens.HOME.title)){
                Text(
                    text = "Todas las tiendas",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        navigationIcon = {
            if (currentRoute.startsWith(Screens.HOME.title)){
                Icon(
                    imageVector = Icons.Default.Store,
                    contentDescription = "Tiendas"
                )
            } else if (currentRoute.startsWith(Screens.REQUEST_DETAIL.title)){
                Row {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        IconButton(onClick = {
                            navController.navigateUp()
                        }) {
                            Icon(imageVector = Icons.Outlined.ArrowBackIosNew, contentDescription = null)
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
                    }
                }
            }
        },
        actions = {
            if (currentRoute.startsWith(Screens.HOME.title)){
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "Navegar a todas las tiendas"
                )
            }
        }
    )
}
