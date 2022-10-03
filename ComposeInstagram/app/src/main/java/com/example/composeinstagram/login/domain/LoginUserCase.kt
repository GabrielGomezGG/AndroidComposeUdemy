package com.example.composeinstagram.login.domain

import com.example.composeinstagram.login.data.network.LoginRepository

class LoginUserCase {

    private val repository = LoginRepository()

    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user,password)
    }

}