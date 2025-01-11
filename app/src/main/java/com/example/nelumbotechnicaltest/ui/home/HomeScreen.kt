package com.example.nelumbotechnicaltest.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.nelumbotechnicaltest.R
import com.example.nelumbotechnicaltest.data.models.Request
import com.example.nelumbotechnicaltest.domain.AppTimeUtil
import com.example.nelumbotechnicaltest.ui.navigation.Screens

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    val requests by viewModel.requests.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRequests()
    }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTopAppBar(navController)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                        .height(48.dp)
                        .background(color = MaterialTheme.colorScheme.primary),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        modifier = Modifier.padding(start = 8.dp),
                        imageVector = Icons.Default.Store,
                        contentDescription = stringResource(R.string.stores),
                        tint = Color.White
                    )
                    Text(
                        text = stringResource(R.string.all_stores),
                        modifier = Modifier.padding(4.dp),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        modifier = Modifier.padding(end = 8.dp),
                        imageVector = Icons.AutoMirrored.Outlined.ArrowForwardIos,
                        contentDescription = stringResource(R.string.all_stores),
                        tint = Color.White
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            val y =
                                size.height - strokeWidth / 2
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(
                                    0f,
                                    y
                                ),
                                end = Offset(
                                    size.width,
                                    y
                                ),
                                strokeWidth = strokeWidth
                            )
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(start = 8.dp, end = 4.dp)

                    ) {
                        Text(
                            text = stringResource(R.string.filter_by),
                            modifier = Modifier.padding(4.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = stringResource(R.string.filter),
                            tint = Color.Black,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    FloatingActionButton(
                        onClick = {},
                        modifier = Modifier
                            .size(72.dp)
                            .offset(y = 32.dp),
                        containerColor = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(R.string.add),
                            tint = Color.White
                        )
                    }

                    TextButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(start = 4.dp, end = 8.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.sort_by),
                            modifier = Modifier.padding(4.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Sort,
                            contentDescription = stringResource(R.string.sort),
                            modifier = Modifier.size(16.dp),
                            tint = Color.Black
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
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
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
    val grayColor = Color(0xFF9d9d9d)
    val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)
    val normalStyle = SpanStyle(color = grayColor)

    Card(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(4.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(text = "# ${request.id}", color = Color(0xFF9d9d9d))
                }
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = request.type ?: stringResource(R.string.n_a),
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(boldStyle) { append(request.name ?: stringResource(R.string.n_a)) }
                },
                fontSize = 24.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .background(
                            color = Color(0xFFec6666),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(4.dp)
                ) {
                    Text(
                        text = request.priority?.name ?: stringResource(R.string.n_a),
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .border(
                            border = BorderStroke(
                                1.dp,
                                MaterialTheme.colorScheme.primary
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(4.dp)
                ) {
                    Text(
                        text = request.status?.description ?: stringResource(R.string.n_a),
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(boldStyle) { append(stringResource(R.string.requested_the)) }
                    withStyle(normalStyle) { append(AppTimeUtil.formatIsoDateToCustom(request.createTime)) }
                },
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(boldStyle) { append(stringResource(R.string.area)) }
                    withStyle(normalStyle) { append(request.area?.name ?: stringResource(R.string.n_a)) }
                },
                fontSize = 16.sp
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(boldStyle) { append(stringResource(R.string.department)) }
                    withStyle(normalStyle) { append(request.department?.name ?: stringResource(R.string.n_a)) }
                },
                fontSize = 16.sp
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(boldStyle) { append(stringResource(R.string.unit)) }
                    withStyle(normalStyle) { append(request.store?.name ?: stringResource(R.string.n_a)) }
                },
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(boldStyle) { append(stringResource(R.string.creator)) }
                    withStyle(normalStyle) { append("${request.createdByUser?.firstName ?: stringResource(R.string.n_a)} ${request.createdByUser?.lastName ?: stringResource(R.string.n_a)}") }
                },
                fontSize = 16.sp
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(boldStyle) { append(stringResource(R.string.supplier)) }
                    withStyle(normalStyle) { append("${request.department?.userManage?.firstName ?: stringResource(R.string.n_a)} ${request.department?.userManage?.lastName ?: stringResource(R.string.n_a)}") }
                },
                fontSize = 16.sp
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(boldStyle) { append(stringResource(R.string.solver)) }
                    withStyle(normalStyle) { append(request.userAttendingId?.toString() ?: stringResource(R.string.n_a)) }
                },
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("${Screens.REQUEST_DETAIL.title}/${request.id}") },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = stringResource(R.string.see_detail))
            }
        }
    }
}
