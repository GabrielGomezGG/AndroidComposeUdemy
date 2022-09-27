package com.example.composecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    var myText by rememberSaveable {
                        mutableStateOf("")
                    }
                    //MyTextFieldOutLined(myText) { myText = it }
                    MyButtons()
                }
            }
        }
    }

}

@Composable
fun MyButtons(){
    var algo by rememberSaveable {
        mutableStateOf(false)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { algo != algo }) {
            Text(text = "algo")
        }
        OutlinedButton(onClick = { algo != algo}) {
            Text(text = "algo outline")
        }
        TextButton(onClick = { algo != algo }) {
            Text(text = "algo TextButton")
        }
    }

}

@Composable
fun MyTextFieldOutLined(myText : String, textChange:(String) -> Unit) {


    Column() {
        OutlinedTextField(
            value = myText,
            onValueChange = { textChange(it) },
            modifier = Modifier.padding(20.dp),
            label = { Text(text = "Algo") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Blue
            )
        )
    }

}

@Composable
fun MyTextField() {

    var myText by rememberSaveable {
        mutableStateOf("")
    }

    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyTextFieldAdvance() {

    var myText by rememberSaveable {
        mutableStateOf("")
    }

    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Intruduce algo: ") })
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
        //MyTextField()
        MyButtons()
    }
}