package com.example.composecatalog

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MySampleAnimations() {
    Column {
        MySimpleAnimation()
        Spacer(modifier = Modifier.size(50.dp))
        MyAnimationSize()
    }
}

@Composable
fun MySimpleAnimation() {


    var firstColor by remember { mutableStateOf(false) }
    var enableBox by remember { mutableStateOf(true) }

    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Green,
        animationSpec = tween(2000),
        finishedListener = { enableBox = !enableBox }
    )

    if (enableBox)
        Box(modifier = Modifier
            .size(60.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor }
        ) {}
}

@Composable
fun MyAnimationSize() {
    var isSize by remember { mutableStateOf(false) }

    val animationSize by animateDpAsState(
        targetValue = if (isSize) 20.dp else 100.dp,
        animationSpec = tween(100),
        finishedListener = {}
    )


    Box(modifier = Modifier
        .size(animationSize)
        .background(Color.Blue)
        .clickable { isSize = !isSize }
    ) {}
}