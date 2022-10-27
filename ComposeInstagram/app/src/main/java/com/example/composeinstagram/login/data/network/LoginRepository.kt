package com.example.composeinstagram.login.data.network

import com.example.composeinstagram.login.data.network.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginService: LoginService
) {

    //private val loginService = LoginService()

    suspend fun doLogin(user:String,password:String):Boolean{
        return loginService.doLogin(user,password)
    }
}