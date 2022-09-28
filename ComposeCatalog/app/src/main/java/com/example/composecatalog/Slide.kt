package com.example.composecatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MySlider() {

    var barra by rememberSaveable {
        mutableStateOf(0f)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Slider(value = barra, onValueChange = { barra = it })

        Text(text = "Barra: $barra")
    }

}

@Preview
@Composable
fun MySliderAdvance() {

    var barra by rememberSaveable {
        mutableStateOf(0f)
    }
    var barraCompletada by rememberSaveable {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Slider(
            value = barra, onValueChange = { barra = it },
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = {barraCompletada = barra.toString()}
        )

        Text(text = "Barra: $barraCompletada")
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun MyRangeSlider() {

    var barra by rememberSaveable {
        mutableStateOf(0f..10f)
    }

    var barraCompletada by rememberSaveable {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        RangeSlider(
            values = barra,
            onValueChange = { barra = it },
            valueRange = 0f..10f,
            steps = 9,
            //onValueChangeFinished = {barraCompletada = barra.toString()}
        )

        Text(text = "Barra: ${barra.start}")
        Text(text = "Barra: ${barra.endInclusive}")
    }

}