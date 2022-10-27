package com.example.composeinstagram.login.ui

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeinstagram.R


@Composable
fun MyLoginScreen(loginViewModel: LoginViewModel) {

    val isLoading by loginViewModel.isLoading.observeAsState(initial = false)

    Box(

        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        if (!isLoading) {
            MyHeader(Modifier.align(Alignment.TopEnd))
            MyBody(Modifier.align(Alignment.Center), loginViewModel)
            MyFooter(Modifier.align(Alignment.BottomCenter))
        } else {
            CircularProgressIndicator()

        }
    }
}

@Composable
fun MyFooter(modifier: Modifier) {

    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
        )
        Spacer(modifier = Modifier.size(24.dp))
        MySingUp(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun MySingUp(modifier: Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "Don't have an account", fontSize = 12.sp, color = Color.Gray)
        Text(
            text = "Sing up.",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            modifier = modifier.padding(horizontal = 6.dp)
        )
    }
}

@Composable
fun MyBody(modifier: Modifier, loginViewModel: LoginViewModel) {

    val email: String by loginViewModel.email.observeAsState(initial = "")

    val password: String by loginViewModel.password.observeAsState(initial = "")

    val isLogin: Boolean by loginViewModel.isLogin.observeAsState(initial = false)

    Column(modifier = modifier) {
        MyLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        MyEmail(email, { loginViewModel.onLoginChange(it, password) }, Modifier)
        Spacer(modifier = Modifier.size(4.dp))
        MyPassword(password, { loginViewModel.onLoginChange(email, it) }, Modifier)
        Spacer(modifier = Modifier.size(8.dp))
        MyForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        MyLoginButton(isLogin, loginViewModel)
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
fun MyEmail(
    email: String,
    onChangeText: (String) -> Unit,
    modifier: Modifier
) {
    TextField(
        value = email,
        onValueChange = { onChangeText(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )

    )
}

@Composable
fun MyLoginButton(login: Boolean, loginViewModel: LoginViewModel) {
    Button(
        onClick = { loginViewModel.onLoginSelect() },
        enabled = login,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4EA8E9),
            disabledBackgroundColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
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

    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    TextField(
        value = password,
        onValueChange = onChangeText,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val imagen = if (passwordVisible) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        },
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }

    )
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