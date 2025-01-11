package com.example.nelumbotechnicaltest.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
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

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTopAppBar()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(4.dp)
                            .offset(y = (-16).dp)
                    ) {
                        Text(
                            text = "Filtrar por",
                            modifier = Modifier.padding(4.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Filtrar",
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    FloatingActionButton(
                        onClick = {},
                        modifier = Modifier
                            .size(56.dp)
                            .offset(y = 24.dp),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Agregar",
                            tint = Color.White
                        )
                    }

                    TextButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(4.dp)
                            .offset(y = (-16).dp)
                    ) {
                        Text(
                            text = "Ordenar por",
                            modifier = Modifier.padding(4.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Sort,
                            contentDescription = "Ordenar",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        },
        bottomBar = {
            CustomBottomApp()
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    if (requests.isEmpty()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    } else {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(requests) { request ->
                                RequestItem(request = request, navController = navController)
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun RequestItem(request: Request, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "# ${request.id}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = request.name ?: "No nombre",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = "Prioridad: ${request.priority?.name ?: "N/A"}",
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Estado: ${request.status?.description ?: "N/A"}",
                )
            }
            Text(
                text = "Solicitada el: ",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Área: ${request.area?.name}",
            )
            Text(
                text = "Departamento: ${request.department?.name}",
            )
            Text(
                text = "Unidad:",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Creador:",
            )
            Text(
                text = "Proveedor:",
            )
            Text(
                text = "Solucionador:",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("${Screens.REQUEST_DETAIL.title}/${request.id}") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Ver detalle")
            }
        }
    }
}
