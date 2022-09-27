package com.example.composecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

                    val myOpcions = getOpcions(listOf("aasdsad", "eqwewqe0", "asdasdas"))
                    Column() {
                        myOpcions.forEach {
                            MyCheckBoxWithTextCompleted(it)
                        }
                    }


                }
            }
        }
    }

}

@Composable
fun getOpcions(title: List<String>): List<CheckBoxInfo> {

    return title.map {
        var estado by rememberSaveable {
            mutableStateOf(true)
        }

        CheckBoxInfo(
            title = it,
            isChecked = estado,
            isChangeCheck = { a -> estado = a }
        )
    }

}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckBoxInfo) {

    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.isChecked,
            onCheckedChange = { checkInfo.isChangeCheck(!checkInfo.isChecked) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red
            )
        )

        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {

    var estado by rememberSaveable {
        mutableStateOf(true)
    }

    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = estado,
            onCheckedChange = { estado = !estado },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red
            )
        )

        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Texto 1")
    }
}

@Composable
fun MySwitch() {
    var estado by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        checked = estado,
        onCheckedChange = { estado = !estado },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red,
            uncheckedThumbColor = Color.Green
        )
    )
}

@Composable
fun MyProgressBar() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 15.dp)
        LinearProgressIndicator(color = Color.Green, backgroundColor = Color.Cyan)

    }
}

@Composable
fun MyProgressBarAdvence() {

    var valor by rememberSaveable {
        mutableStateOf(0f)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = valor)

        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { valor += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { valor -= 0.1f }) {
                Text(text = "Reducir")
            }
        }

    }
}

@Composable
fun MyImages() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = Modifier
            .clip(shape = CircleShape)
            .border(10.dp, color = Color.Blue, CircleShape)
    )
}

@Composable
fun MyIcons() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = null)
}

@Composable
fun MyButtons() {
    val algo by rememberSaveable {
        mutableStateOf(false)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { algo != algo }) {
            Text(text = "algo")
        }
        OutlinedButton(onClick = { algo != algo }) {
            Text(text = "algo outline")
        }
        TextButton(onClick = { algo != algo }) {
            Text(text = "algo TextButton")
        }
    }

}

@Composable
fun MyTextFieldOutLined(myText: String, textChange: (String) -> Unit) {


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
        //MyButtons()
        //MyImages()
        MyIcons()
    }
}