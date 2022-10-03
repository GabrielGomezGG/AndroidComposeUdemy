package com.example.composecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.composecatalog.Routes.*

@Composable
fun pantalla1(navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            text = "Text1",
            Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Pantalla2.route) }
        )
    }
}

@Composable
fun pantalla2(navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Text2",
            Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Pantalla3.route) })
    }
}

@Composable
fun pantalla3(navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Text3",
            Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Pantalla4.createRoute("algo"))
                }
        )
    }
}

@Composable
fun pantalla4(navigationController: NavHostController, name : String) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "I AM THE BEST $name",
            Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Pantalla1.route) })
    }
}