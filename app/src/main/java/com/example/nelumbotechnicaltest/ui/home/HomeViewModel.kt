package com.example.nelumbotechnicaltest.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nelumbotechnicaltest.data.models.Request
import com.example.nelumbotechnicaltest.domain.use_case.FetchRequestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchRequestUseCase: FetchRequestUseCase
) : ViewModel() {

    private val _requests = MutableStateFlow<List<Request>>(emptyList())
    val requests: StateFlow<List<Request>> get() = _requests

    fun loadRequests() {
        viewModelScope.launch {
            try {
                val requests = fetchRequestUseCase(6,"DESC")
                _requests.value = requests
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}