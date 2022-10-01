package com.example.composecatalog

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyScaffol() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { MyTopAppBar {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Has pulsado $it")
            }
        } },

    ) {

    }

}

@Composable
fun MyTopAppBar(onIconClick:(String) -> Unit) {
    TopAppBar(
        title = { Text(text = "Primera app") },
        backgroundColor = Color(170,0,0),
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onIconClick("Atras") }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(onClick = { onIconClick("Buscar") }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = ""
                )
            }
            IconButton(onClick = { onIconClick("Agregar") }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = ""
                )
            }
        }
    )
}