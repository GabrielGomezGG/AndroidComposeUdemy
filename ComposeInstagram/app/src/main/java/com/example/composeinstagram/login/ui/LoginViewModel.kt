package com.example.composeinstagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeinstagram.login.domain.LoginUserCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val loginUserCase = LoginUserCase()

    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin : LiveData<Boolean> = _isLogin

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    fun onLoginChange(email : String, password : String) {
        _email.value = email
        _password.value = password
        _isLogin.value = enableButton(email,password)
    }


    private fun enableButton(email: String, password: String) : Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 7
    }

    fun onLoginSelect(){
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUserCase(email.value!!, password.value!!)

            if(result){
                Log.i("Titi", "asdasd $result")
            }
            _isLoading.value = false
        }
    }
}
