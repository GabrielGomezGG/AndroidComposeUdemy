package com.example.composecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview
@Composable
fun qwe() {
    val focusRequester = remember { FocusRequester() }
    var color by remember { mutableStateOf(Black) }
    Box(
        Modifier
            .fillMaxSize()
            .clickable { focusRequester.requestFocus() }
            .border(2.dp, color)
            // The focusRequester should be added BEFORE the focusable.
            .focusRequester(focusRequester)
            // The onFocusChanged should be added BEFORE the focusable that is being observed.
            .onFocusChanged { color = if (it.isFocused) Green else Black }
            .focusable()
    )
}

@Preview
@Composable
fun MyScaffol() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(
                onClickIcon = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "Has pulsado $it",
                            duration = SnackbarDuration.Short,
                            actionLabel = "Algo"
                        )
                    }
                }, onClickMenu = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFAB() },

        //ignora el bottomBar y lo posiciona donde le digas
        //isFloatingActionButtonDocked = true,
        //floatingActionButtonPosition = FabPosition.Center

        drawerContent = { MyModelDrawer {
            coroutineScope.launch {
                scaffoldState.drawerState.close()
            }
        } },
        drawerGesturesEnabled = false

    ) {

    }
}

@Composable
fun MyModelDrawer(onCloseDrawe: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(text = "Algo1", modifier = Modifier
            .fillMaxWidth()
            .clickable { onCloseDrawe() })
        Text(text = "Algo1", modifier = Modifier
            .fillMaxWidth()
            .clickable { onCloseDrawe() })
        Text(text = "Algo1", modifier = Modifier
            .fillMaxWidth()
            .clickable { onCloseDrawe() })
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color(0xFF3DFFCC),
        contentColor = Color(0xFF992805)
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
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
            onClick = { index = 1 },
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
fun MyTopAppBar(
    onClickIcon: (String) -> Unit,
    onClickMenu: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Primera app") },
        backgroundColor = Color(170, 0, 0),
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickMenu() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = ""
                )
            }
            IconButton(onClick = { onClickIcon("Agregar") }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = ""
                )
            }
        }
    )
}