package com.example.composeinstagram.login.domain

import com.example.composeinstagram.login.data.network.LoginRepository

class LoginUserCase {

    private val repository = LoginRepository()

    suspend fun doLogin(user:String, password:String):Boolean{
        return repository.doLogin(user,password)
    }

}