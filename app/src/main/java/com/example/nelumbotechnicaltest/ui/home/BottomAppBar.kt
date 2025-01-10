package com.example.nelumbotechnicaltest.ui.home

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable

@Composable
fun CustomBottomApp() {

    val menuItems = listOf(
        ItemsBottomNav.ItemPrincipal,
        ItemsBottomNav.ItemCalendar,
        ItemsBottomNav.ItemStore,
        ItemsBottomNav.ItemFolder,
    )

    BottomAppBar {
        NavigationBar {
            menuItems.forEach { item ->
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    }
                )
            }
        }
    }
}