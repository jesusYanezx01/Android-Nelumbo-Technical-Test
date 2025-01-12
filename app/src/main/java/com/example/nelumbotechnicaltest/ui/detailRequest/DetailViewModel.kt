package com.example.nelumbotechnicaltest.ui.detailRequest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nelumbotechnicaltest.domain.use_case.FetchDetailRequestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val fetchDetailRequestUseCase: FetchDetailRequestUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> get() = _uiState

    fun loadDetail(requestId: String) {
        viewModelScope.launch {
            val result = fetchDetailRequestUseCase.execute(requestId)

            result.onSuccess { detail ->
                _uiState.value = _uiState.value.copy(
                    detail = detail,
                    error = null
                )
            }.onFailure { exception ->
                _uiState.value = _uiState.value.copy(
                    detail = null,
                    error = exception.message
                )
            }
        }
    }
}
