package com.example.retocopiatuits.TuitScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyTuitScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF181841))
        .padding(8.dp)
    ) {
        Row() {
            MyPhotoProfile(Modifier.weight(1f))
            Spacer(modifier = Modifier.size(12.dp))
            MyAutorTuit(Modifier.weight(5f))
        }
    }
}