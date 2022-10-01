package com.example.composecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecatalog.ui.theme.ComposeCatalogTheme
import com.example.composecatalog.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController,
                    startDestination = "pantalla1"
                    ){
                        composable("pantalla1"){ pantalla1(navigationController)}
                        composable("pantalla2"){ pantalla2(navigationController)}
                        composable("pantalla3"){ pantalla3(navigationController)}
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MyDropdownMenu() {
    var selectText by rememberSaveable {
        mutableStateOf("")
    }

    var expended by rememberSaveable {
        mutableStateOf(false)
    }

    var postres = listOf<String>("adas","qwewqe","zxczcz","klkhi")

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = selectText,
            onValueChange = { selectText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expended = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            postres.forEach{postre ->
                DropdownMenuItem(onClick = {
                    expended=false
                    selectText = postre
                }) {
                    Text(text = postre)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyBadgeBox() {
    BadgedBox(

        badge = {
            Badge { Text(text = "10") }
        }) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite"
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 50.dp,
        shape = Shapes.medium,
        backgroundColor = Color.Magenta,
        border = BorderStroke(12.dp, Color.Red)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Titulo", Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text(
                text = "Lorem asdksaidksaj ajskdlsajfklsa jaklsdjsalkjdlksa",
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Left

            )
        }
    }
}

@Composable
fun MyRadioBottonList(name: String, isSelect: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "titi", onClick = { isSelect("titi") })
            Text(text = "titi")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "toto", onClick = { isSelect("toto") })
            Text(text = "toto")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "tata", onClick = { isSelect("tata") })
            Text(text = "tata")
        }
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
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