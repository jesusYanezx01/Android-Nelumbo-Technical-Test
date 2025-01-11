package com.example.nelumbotechnicaltest.ui.detailRequest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, requestId: String?, viewModel: DetailViewModel = hiltViewModel()) {

    LaunchedEffect(requestId) {
        if (requestId != null) {
            viewModel.loadDetail(requestId)
        }
    }

    val detail by viewModel.detail.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "#${detail?.id} - ${detail?.name}",
                modifier = Modifier.weight(1f)
            )
            Text(text = detail?.type ?: "N/A")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = detail?.area?.name ?: "N/A")
            Text(text = detail?.status?.description ?: "N/A")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "15 Días Transcurridos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Text(
            text = "Descripción",
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = detail?.description ?: "N/A",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OptionRow("Evidencias", Icons.Default.AttachFile)
            OptionRow("Opciones avanzadas", Icons.AutoMirrored.Filled.ArrowForward)
            OptionRow("Informe de folio", Icons.Default.Visibility)
            OptionRow("Comentarios", Icons.AutoMirrored.Filled.ArrowForward, notificationCount = 1)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Historial",
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(16.dp)
        ) {
            Text(text = "Pedir cotización")

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Proveedor: ${detail?.department?.userManage?.firstName ?: "N/A"} ${detail?.department?.userManage?.lastName ?: "N/A"}"
                )
            }

            Spacer(modifier = Modifier.fillMaxWidth())
            TextButton(onClick = {}) {
                Text(text = "Reasignar proveedor")
            }

            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Pedir cotización")
            }
        }
    }
}

@Composable
fun OptionRow(title: String, imageVector: ImageVector, notificationCount: Int? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = title)
            notificationCount?.let {
                Spacer(modifier = Modifier.width(8.dp))
                Badge { Text(it.toString()) }
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = imageVector, contentDescription = null)
        }
    }
}
