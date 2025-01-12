package com.example.nelumbotechnicaltest.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nelumbotechnicaltest.domain.model.Login
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

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    fun login(login: Login) {
        viewModelScope.launch {
            val result = loginUseCase.execute(login)

            result.onSuccess {
                loadRequests()
            }.onFailure { exception ->
                _uiState.value = _uiState.value.copy(
                    loginState = Result.failure(exception),
                    error = exception.message
                )
            }
        }
    }

    private fun loadRequests() {
        viewModelScope.launch {
            val result = fetchRequestUseCase.execute(6, "DESC")

            result.onSuccess { requests ->
                _uiState.value = _uiState.value.copy(
                    requests = requests,
                    error = null
                )
            }.onFailure { exception ->
                _uiState.value = _uiState.value.copy(
                    requests = emptyList(),
                    error = exception.message
                )
            }
        }
    }
}
