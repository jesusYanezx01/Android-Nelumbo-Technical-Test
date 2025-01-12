package com.example.nelumbotechnicaltest.ui.home

import com.example.nelumbotechnicaltest.domain.model.Request

data class HomeUiState(
    val loginState: Result<Unit>? = null,
    val requests: List<Request>? = emptyList(),
    val error: String? = null
)
