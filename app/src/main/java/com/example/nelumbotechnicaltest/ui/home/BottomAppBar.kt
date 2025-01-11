package com.example.nelumbotechnicaltest.ui.home

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomBottomApp() {

    val menuItems = listOf(
        ItemsBottomNav.ItemPrincipal,
        ItemsBottomNav.ItemCalendar,
        ItemsBottomNav.ItemStore,
        ItemsBottomNav.ItemFolder
    )

    BottomAppBar {
        NavigationBar {
            menuItems.forEach { item ->
                NavigationBarItem(
                    selected = item == ItemsBottomNav.ItemFolder,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title) },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
        }
    }
}