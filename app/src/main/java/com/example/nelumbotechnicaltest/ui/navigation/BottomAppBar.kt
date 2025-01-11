package com.example.nelumbotechnicaltest.ui.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.nelumbotechnicaltest.ui.home.ItemsBottomNav

@Composable
fun CustomBottomApp() {

    val menuItems = listOf(
        ItemsBottomNav.ItemPrincipal,
        ItemsBottomNav.ItemCalendar,
        ItemsBottomNav.ItemStore,
        ItemsBottomNav.ItemFolder
    )

    BottomAppBar(
        modifier = Modifier.shadow(16.dp, shape = RectangleShape),
        containerColor = Color.White,
        content = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.onPrimary
            ) {
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
                        label = {
                            Text(
                                text = item.title,
                                color = Color(0xFF1976D2)
                            )
                        },
                        alwaysShowLabel = true,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF1976D2),
                            unselectedIconColor = Color(0xFF1976D2),
                            indicatorColor = Color(0xFF518EC5).copy(0.5f)
                        )
                    )
                }
            }
        }
    )
}
