package com.example.nelumbotechnicaltest.ui.detailRequest

import com.example.nelumbotechnicaltest.domain.model.Request

data class DetailUiState(
    val detail: Request? = null,
    val error: String? = null
)
