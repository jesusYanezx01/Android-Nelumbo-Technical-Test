package com.example.nelumbotechnicaltest.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.nelumbotechnicaltest.R
import com.example.nelumbotechnicaltest.ui.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF313131)
        ),
        title = {
            if (currentRoute.startsWith(Screens.HOME.title)){
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        navigationIcon = {
             if (currentRoute.startsWith(Screens.REQUEST_DETAIL.title)){
                Row {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        IconButton(onClick = {
                            navController.navigateUp()
                        }) {
                            Icon(
                                imageVector = Icons.Outlined.ArrowBackIosNew,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        },
        actions = {
            if (currentRoute.startsWith(Screens.HOME.title)) {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Mi perfil",
                    tint = Color.White
                )
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notificaciones",
                    tint = Color.White
                )
            } else if (currentRoute.startsWith(Screens.REQUEST_DETAIL.title)) {
                BadgedBox(
                    badge = {
                        Badge {
                            Text(
                                text = "3+",
                                color = Color.White
                            )
                        }
                    }
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notificaciones",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    )
}
