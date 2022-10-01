package com.example.composecatalog

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyScaffol() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "Has pulsado $it",
                        duration = SnackbarDuration.Short,
                        actionLabel = "Algo"
                    )
                }
            }
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation() }

    ) {
    }
}

@Composable
fun MyBottomNavigation() {

    var index by rememberSaveable {
        mutableStateOf(0)
    }

    BottomNavigation(
        backgroundColor = Color(170, 0, 0),
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "boton"
                )
            },
            label = { Text(text = "Home") }
        )
        BottomNavigationItem(
            selected = index == 1,
            onClick = { index = 1},
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "boton"
                )
            },
            label = { Text(text = "Home") }
        )
        BottomNavigationItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "boton"
                )
            },
            label = { Text(text = "Home") }
        )
    }

}

@Composable
fun MyTopAppBar(onIconClick: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "Primera app") },
        backgroundColor = Color(170, 0, 0),
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