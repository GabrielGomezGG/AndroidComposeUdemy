package com.example.composeinstagram.login.data.network

import com.example.composeinstagram.login.data.network.network.LoginService

class LoginRepository {

    private val api = LoginService()

    suspend fun doLogin(user:String,password:String):Boolean{
        return api.doLogin(user,password)
    }
}