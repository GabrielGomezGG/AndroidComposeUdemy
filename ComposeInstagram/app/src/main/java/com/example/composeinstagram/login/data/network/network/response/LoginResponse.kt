package com.example.composeinstagram.login.data.network.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success")val success:Boolean
)
