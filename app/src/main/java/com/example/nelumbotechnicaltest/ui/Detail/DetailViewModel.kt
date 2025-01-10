package com.example.nelumbotechnicaltest.ui.Detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nelumbotechnicaltest.data.models.Request
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

    fun loadDetail(requestId: String) {
        viewModelScope.launch {
            try {
                val detail = fetchDetailRequestUseCase(requestId)
                _detail.value = detail
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
