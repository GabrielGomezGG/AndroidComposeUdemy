package com.example.composeinstagram.login.domain

import com.example.composeinstagram.login.data.network.LoginRepository
import javax.inject.Inject

class LoginUserCase @Inject constructor(
    private val loginRepository: LoginRepository
){

    //private val repository = LoginRepository()

    suspend fun doLogin(user:String, password:String):Boolean{
        return loginRepository.doLogin(user,password)
    }

}