package com.example.nelumbotechnicaltest.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nelumbotechnicaltest.data.models.Request
import com.example.nelumbotechnicaltest.domain.use_case.FetchRequestUseCase
import com.example.nelumbotechnicaltest.domain.use_case.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchRequestUseCase: FetchRequestUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loginState = MutableStateFlow<Result<Unit>?>(null)

    private val _requests = MutableStateFlow<List<Request>>(emptyList())
    val requests: StateFlow<List<Request>> get() = _requests

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    // Credentials on a stick as a test
    fun login(userName: String = "y.cordoba@nelumbo.com.co", password: String = "Ana1234567") {
        viewModelScope.launch {
            val result = loginUseCase.execute(userName, password)

            result.onSuccess {
                loadRequests()
            }.onFailure { exception ->
                _loginState.value = Result.failure(exception)
                _error.value = exception.message
            }
        }
    }

    private fun loadRequests() {
        viewModelScope.launch {
            val result = fetchRequestUseCase.execute(6, "DESC")

            result.onSuccess { requests ->
                _requests.value = requests
                _error.value = null
            }.onFailure { exception ->
                _requests.value = emptyList()
                _error.value = exception.message
            }
        }
    }
}