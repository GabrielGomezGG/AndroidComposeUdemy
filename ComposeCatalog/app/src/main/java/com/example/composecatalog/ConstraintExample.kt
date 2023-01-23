package com.example.composecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun ConstraintLayoutExampleOne() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed,boxBlue,boxGreen,boxMagenta, boxYellow) = createRefs()

        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Blue).constrainAs(boxBlue){
            top.linkTo(boxRed.bottom)
            end.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Yellow).constrainAs(boxYellow){
            top.linkTo(boxRed.bottom)
            start.linkTo(boxRed.end)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Green).constrainAs(boxGreen){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxRed.top)
            start.linkTo(boxRed.end)
        })
    }
}