package com.example.nelumbotechnicaltest.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nelumbotechnicaltest.domain.use_case.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loginState = MutableStateFlow<Result<Unit>?>(null)
    val loginState = _loginState.asStateFlow()

    fun login(userName: String, password: String) {
        viewModelScope.launch {
            val result = loginUseCase(userName, password)
            _loginState.value = result
        }
    }

    fun resetLoginState() {
        _loginState.value = null
    }
}
