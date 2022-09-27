package com.example.layoutejemplo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutejemplo.ui.theme.LayoutEjemploTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutEjemploTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyLayoutEjemplo()
                }
            }
        }
    }
}

@Composable
fun MyLayoutEjemplo(){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {Text(text = "asdsadsa")}

        MySpacer(sizeW = 0, sizeH = 10)

            Row(modifier =
            Modifier
                .fillMaxWidth()
                .weight(1f)
            )
            {
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                    contentAlignment = Alignment.Center
                ){Text(text = "asdsadsa")}
                MySpacer(sizeW = 10, sizeH = 0)
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue),
                    contentAlignment = Alignment.Center
                ){ Text(text = "asdsadsa")}
            }
        MySpacer(sizeW = 0, sizeH = 10)
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ){ Text(text = "asdsadsa")}
    }
}

@Composable
fun MySpacer(sizeW : Int, sizeH : Int){
    Spacer(modifier = Modifier
        .width(sizeW.dp)
        .height(sizeH.dp))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LayoutEjemploTheme {
        MyLayoutEjemplo()
    }
}