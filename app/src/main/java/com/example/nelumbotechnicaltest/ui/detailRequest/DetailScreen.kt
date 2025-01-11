package com.example.nelumbotechnicaltest.ui.detailRequest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.DoubleArrow
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.nelumbotechnicaltest.R
import com.example.nelumbotechnicaltest.ui.common.components.OptionRow
import com.example.nelumbotechnicaltest.ui.navigation.CustomTopAppBar

@Composable
fun DetailScreen(
    navController: NavHostController,
    requestId: String?,
    viewModel: DetailViewModel = hiltViewModel()
) {

    LaunchedEffect(requestId) {
        if (requestId != null) {
            viewModel.loadDetail(requestId)
        }
    }

    val detail by viewModel.detail.collectAsState()

    Scaffold(
        topBar = {
            CustomTopAppBar(navController)
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(
                        color = MaterialTheme.colorScheme.onPrimary,
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (detail == null) {
                    CircularProgressIndicator()
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFF5805d0),
                                            Color(0xFF8b1ffd)
                                        ),
                                        start = Offset(0f, 0f),
                                        end = Offset(0f, Float.POSITIVE_INFINITY)
                                    )
                                )
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 24.dp, vertical = 16.dp),
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .height(30.dp)
                                            .background(
                                                color = Color(0xFFec6666),
                                                shape = RoundedCornerShape(16.dp)
                                            )
                                            .padding(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = detail?.priority?.name
                                                ?: stringResource(R.string.n_a),
                                            color = Color.White,
                                            fontSize = 16.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Box(
                                        modifier = Modifier
                                            .height(30.dp)
                                            .background(
                                                color = MaterialTheme.colorScheme.onPrimary,
                                                shape = RoundedCornerShape(16.dp)
                                            )
                                            .border(
                                                border = BorderStroke(
                                                    1.dp,
                                                    MaterialTheme.colorScheme.primary
                                                ),
                                                shape = RoundedCornerShape(16.dp)
                                            )
                                            .padding(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = detail?.status?.description
                                                ?: stringResource(R.string.n_a),
                                            color = MaterialTheme.colorScheme.primary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "#${detail?.id} - ${detail?.name}",
                                    color = Color.White,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(vertical = 4.dp)
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(30.dp)
                                            .background(
                                                color = Color(0xFF4a01c4),
                                                shape = RoundedCornerShape(16.dp)
                                            )
                                            .padding(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = detail?.type ?: stringResource(R.string.n_a),
                                            modifier = Modifier.padding(horizontal = 8.dp),
                                            color = Color.White,
                                            fontSize = 16.sp
                                        )
                                    }
                                    TextButton(
                                        onClick = { },
                                        modifier = Modifier.padding(start = 8.dp, end = 4.dp)
                                    ) {
                                        Text(
                                            text = stringResource(R.string.see_more),
                                            modifier = Modifier.padding(4.dp),
                                            color = Color.White,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Icon(
                                            imageVector = Icons.Default.DoubleArrow,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                }
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFec6666))
                                .height(56.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "15 Días Transcurridos",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                fontSize = 24.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = "Descripción",
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = detail?.description ?: "N/A",
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OptionRow("Evidencias", Icons.Default.AttachFile, Color(0xFF4a01c4))
                            OptionRow("Opciones avanzadas", Icons.AutoMirrored.Filled.ArrowForward)
                            OptionRow("Informe de folio", Icons.Default.Visibility)
                            OptionRow(
                                "Comentarios",
                                Icons.AutoMirrored.Filled.ArrowForward,
                                notificationCount = 1
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Historial",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }

                        HorizontalDivider(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp),
                            thickness = 1.dp,
                            color = Color(0xFFBDBDBD)
                        )

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Pedir cotización",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1976D2)
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Proveedor: ${detail?.department?.userManage?.firstName ?: "N/A"} ${detail?.department?.userManage?.lastName ?: "N/A"}",
                                    color = Color(0xFF757575),
                                    fontSize = 18.sp
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                OutlinedButton(
                                    onClick = {},
                                    modifier = Modifier.fillMaxWidth(),
                                    border = BorderStroke(1.dp, Color(0xFF1976D2)),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(
                                        text = "Reasignar proveedor",
                                        color = Color(0xFF1976D2),
                                        fontSize = 18.sp
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Button(
                                    onClick = {},
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonColors(
                                        containerColor = Color(0xFF1976D2),
                                        contentColor = Color.White,
                                        disabledContainerColor = Color.Unspecified,
                                        disabledContentColor = Color.Unspecified,
                                    )
                                ) {
                                    Text(
                                        text = "Pedir cotización",
                                        fontSize = 18.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
