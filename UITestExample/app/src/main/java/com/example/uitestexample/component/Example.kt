package com.example.uitestexample.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MainScreen() {
    var textOne by rememberSaveable { mutableStateOf("") }
    var textTwo by rememberSaveable { mutableStateOf("") }
    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        TextField(value = textOne, onValueChange = {textOne = it}, Modifier.testTag("textOne"))
        Spacer(modifier = Modifier.size(6.dp))
        Button(onClick = { textTwo = textOne }) {
            Text(text = "Button")
        }
        Spacer(modifier = Modifier.size(6.dp))
        Text(text = textTwo, Modifier.testTag("textFinal") )
    }
}