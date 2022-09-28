package com.example.composeinstagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyBody(modifier: Modifier) {

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var isLogin by rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {
        MyLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        MyEmail(email, { email = it }, Modifier)
        Spacer(modifier = Modifier.size(4.dp))
        MyPassword(password, { password = it }, Modifier)
        Spacer(modifier = Modifier.size(8.dp))
        MyForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        MyLoginButton(isLogin)
        Spacer(modifier = Modifier.size(8.dp))
        MyLoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        MyLoginWithFacebook()
    }
}

@Composable
fun MyLoginWithFacebook() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "facebook",
            Modifier.size(16.dp)
        )
        Text(
            text = "Continue as Gabriel Gomez",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color(0xFF4EA8E9),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyLoginDivider() {
    Row {
        Divider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5),
            modifier = Modifier.padding(horizontal = 16.dp)

        )
        Divider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun MyLoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        MyHeader(Modifier.align(Alignment.TopEnd))
        MyBody(Modifier.align(Alignment.Center))
    }
}

@Composable
fun MyEmail(
    email: String,
    onChangeText: (String) -> Unit,
    modifier: Modifier
) {
    TextField(value = email, onValueChange = onChangeText, modifier = modifier.fillMaxWidth())
}

@Composable
fun MyLoginButton(login: Boolean) {
    Button(onClick = { /*TODO*/ }, enabled = login, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Log In")
    }
}

@Composable
fun MyForgotPassword(modifier: Modifier) {
    Text(
        text = "Forget password?",
        color = Color(0xFF4EA8E9),
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun MyPassword(password: String, onChangeText: (String) -> Unit, modifier: Modifier) {
    TextField(value = password, onValueChange = onChangeText, modifier = modifier.fillMaxWidth())
}

@Composable
fun MyLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "logo",
        modifier = modifier
    )
}

@Composable
fun MyHeader(modifier: Modifier) {

    val activity = LocalContext.current as Activity

    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "salir",
        modifier = modifier
            .clickable { activity.finish() }
    )
}