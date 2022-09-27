package com.example.composecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composecatalog.ui.theme.ComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyText()
                }
            }
        }
    }

}

@Composable
fun MyTextField(){

    var myText by rememberSaveable {
        mutableStateOf("")
    }

    TextField(value = myText, onValueChange = {myText = it})
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Texto normal")
        Text(text = "Texto negro", fontWeight = FontWeight.Bold)
        Text(text = "Texto liviana", fontWeight = FontWeight.Light)
        Text(text = "Texto cursiva", fontFamily = FontFamily.Cursive)
        Text(text = "Texto h1", fontSize = 20.sp)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCatalogTheme {
        //MyText()
        MyTextField()
    }
}