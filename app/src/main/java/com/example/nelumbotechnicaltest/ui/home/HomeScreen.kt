package com.example.nelumbotechnicaltest.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nelumbotechnicaltest.data.models.Request
import com.example.nelumbotechnicaltest.ui.navigation.Screens

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val requests by viewModel.requests.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRequests()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Home Screen",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (requests.isEmpty()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(requests) { request ->
                    RequestItem(request = request, navController = navController)
                }
            }
        }
    }
}

@Composable
fun RequestItem(request: Request, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("${Screens.REQUEST_DETAIL.title}/${request.id}")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Nombre: ${request.name ?: "No nombre"}")
            Text(text = "Descripcion: ${request.description ?: "No descripcion"}")
            Text(text = "Estado prioridad: ${request.priority?.name}")
            Text(text = "Estado actual: ${request.status?.description}")
            Text(text = "area: ${request.area}")
            Text(text = "departamento: ${request.department}")
            Text(text = "creador: ${request.createdByUser?.firstName ?: "N.N"} ${request.createdByUser?.lastName}")
        }
    }
}
