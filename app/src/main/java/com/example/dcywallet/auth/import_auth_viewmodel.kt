package com.example.dcywallet.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ImportAuthViewModel: ViewModel()  {
    private val _seedPhrase = MutableStateFlow("")
    var seedPhrase = _seedPhrase.asStateFlow()

    fun onChangedSeedPhrase(newSeedPhrase: String){
        _seedPhrase.value = newSeedPhrase
    }
    private val _newPassword = MutableStateFlow("")
    var newPassword = _newPassword.asStateFlow()

    fun onChangedNewPassword(newPassword: String){
        _newPassword.value = newPassword
    }

    private val _confirmNewPassword = MutableStateFlow("")
    var confirmNewPassword = _confirmNewPassword.asStateFlow()

    fun onChangedConfirmNewPassword(confirmNewPassword: String){
        _confirmNewPassword.value = confirmNewPassword
    }

    private val _formValidated = MutableStateFlow(false)
    var formValidated = _formValidated.asStateFlow()

    fun validateForm(){

    }
}