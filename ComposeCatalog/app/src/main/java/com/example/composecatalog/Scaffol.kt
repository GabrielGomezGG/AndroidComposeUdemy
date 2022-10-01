package com.example.composecatalog

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyScaffol() {


    Scaffold(
        topBar = { MyTopAppBar() }
    ) {

    }

}

@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(text = "Primera app") },
        backgroundColor = Color.Cyan,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = ""
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = ""
                )
            }
        }
    )
}