package com.example.nelumbotechnicaltest.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Store
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ItemsBottomNav(
    val icon: ImageVector,
    val title: String,
    val route: String
){
    data object ItemPrincipal : ItemsBottomNav(
        Icons.Default.CheckCircle,
        "principal",
        "principal")

    data object ItemCalendar: ItemsBottomNav(
        Icons.Default.CalendarToday,
        "Agenda",
        "calendar"
    )

    data object ItemStore : ItemsBottomNav(
        Icons.Default.Store,
        "Tiendas",
        "store"
    )

    data object ItemFolder : ItemsBottomNav(
        Icons.Default.Folder,
        "Folios",
        "folder"
    )
}