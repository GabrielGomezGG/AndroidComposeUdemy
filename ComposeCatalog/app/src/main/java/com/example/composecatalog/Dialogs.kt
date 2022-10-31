package com.example.composecatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Preview
@Composable
fun MyMostrarDialog() {
    var mostrar by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { mostrar = true }) {
            Text(text = "Mostrar Dialog")
        }
//        MyDialog(
//            mostrar,
//            { mostrar = false },
//            { Log.i("titi", "probando") }
//        )
//        MyDialogSimple(
//            mostrar = mostrar,
//            onDismiss = { mostrar = false }
//        )
        MyDialogCustom(mostrar = mostrar, onDismiss = { mostrar = false })
        //MyComfirmDialog(mostrar = mostrar, onDismiss = {mostrar = false})

    }

}

@Composable
fun MyComfirmDialog(
    mostrar: Boolean,
    onDismiss: () -> Unit,
) {
    if (mostrar) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(title = "Musica", modifier = Modifier )
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                )

                var status by rememberSaveable {
                    mutableStateOf("")
                }

                MyRadioBottonList(name = status, isSelect = { status = it })

                Divider(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                )
                Row(Modifier.align(Alignment.End)) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Aceptar")
                    }
                }
            }
        }
    }
}

@Composable
fun MyDialogCustom(
    mostrar: Boolean,
    onDismiss: () -> Unit,
) {
    if (mostrar) {
        Dialog(
            onDismissRequest = onDismiss
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White)
            ) {
                MyTitleDialog(title = "Algo", modifier = Modifier)
                MyAccountItem(
                    email = "asdsad@gmail.com",
                    drawable = R.drawable.avatar,
                    modifier = Modifier
                )
                MyAccountItem(
                    email = "weqewqewq@gmail.com",
                    drawable = R.drawable.avatar,
                    modifier = Modifier
                )
                MyAccountItem(
                    email = "Añadir cuenta",
                    drawable = R.drawable.add,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun MyAccountItem(
    email: String,
    @DrawableRes drawable: Int,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "icon",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
fun MyTitleDialog(
    title: String,
    modifier: Modifier,
) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
            .padding(12.dp)
    )
}

@Composable
fun MyDialogSimple(
    mostrar: Boolean,
    onDismiss: () -> Unit,
) {
    if (mostrar) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            )
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.Green)
            ) {
                Text(text = "adasdasds")
                Text(text = "adasdasds")
                Text(text = "adasdasds")
            }
        }
    }
}

@Composable
fun MyDialog(
    mostrar: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (mostrar) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Descripcion") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Boton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Calcelar")
                }
            }
        )
    }
}