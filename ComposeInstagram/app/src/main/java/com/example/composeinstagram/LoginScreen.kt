package com.example.composeinstagram

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun MyLoginScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
    ){
        MyHeader(Modifier.align(Alignment.TopEnd))
    }
}

@Composable
fun MyHeader(modifier: Modifier){

    val activity = LocalContext.current as Activity

    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "salir",
        modifier = modifier
            .clickable { activity.finish() }
    )
}