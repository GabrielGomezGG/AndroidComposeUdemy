package com.example.composeinstagram.login.data.network.network

import com.example.composeinstagram.core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {

    val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user:String,password:String):Boolean{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.success ?: false
        }
    }

}