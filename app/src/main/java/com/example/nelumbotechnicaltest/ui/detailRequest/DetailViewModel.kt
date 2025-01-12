package com.example.nelumbotechnicaltest.ui.detailRequest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nelumbotechnicaltest.domain.model.Request
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

    private val _detail = MutableStateFlow<Request?>(null)
    val detail: StateFlow<Request?> get() = _detail

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun loadDetail(requestId: String) {
        viewModelScope.launch {
            val result = fetchDetailRequestUseCase.execute(requestId)

            result.onSuccess { detail ->
                _detail.value = detail
                _error.value = null
            }.onFailure { exception ->
                _detail.value = null
                _error.value = exception.message
            }
        }
    }
}
