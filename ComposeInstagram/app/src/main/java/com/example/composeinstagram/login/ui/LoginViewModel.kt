package com.example.composeinstagram.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin : LiveData<Boolean> = _isLogin

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    fun onLoginChange(email : String, password : String) {
        _email.value = email
        _password.value = password
        _isLogin.value = enableButton(email,password)
    }


    fun enableButton(email: String, password: String) : Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 7
    }
}
