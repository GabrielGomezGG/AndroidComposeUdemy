package com.example.retocopiatuits.TuitScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.retocopiatuits.R

@Composable
fun MyComents(modifier: Modifier = Modifier) {

    var isClicked by rememberSaveable {
        mutableStateOf(false)
    }

    val imagen = if (!isClicked) {
        painterResource(id = R.drawable.ic_chat)
    } else {
        painterResource(id = R.drawable.ic_chat_filled)
    }


    var numbers by rememberSaveable {
        mutableStateOf(1)
    }



    Box(modifier = modifier
        .fillMaxWidth()) {
        BadgedBox(badge = {
            Text(text = numbers.toString(), color = Color.Gray)
        }) {
            Icon(
                painter = imagen,
                contentDescription = "comment",
                Modifier
                    .size(25.dp)
                    .clickable {
                        isClicked = !isClicked

                        if (isClicked) {
                            numbers++
                        } else {
                            numbers--
                        }

                    },
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun MyRT(modifier: Modifier = Modifier) {

    var isClicked by rememberSaveable {
        mutableStateOf(false)
    }

    val imagen = painterResource(id = R.drawable.ic_rt)


    var numbers by rememberSaveable {
        mutableStateOf(1)
    }

    var colorRt = if(isClicked) {
        Color.Green
    }else{
        Color.Gray
    }

    Box(modifier = modifier
        .fillMaxWidth()) {
        BadgedBox(badge = {
            Text(text = numbers.toString(), color = Color.Gray)
        }) {
            Icon(
                painter = imagen,
                contentDescription = "rt",
                Modifier
                    .size(25.dp)
                    .clickable {
                        isClicked = !isClicked

                        if (isClicked) {
                            numbers++
                        } else {
                            numbers--
                        }

                    },
                tint = colorRt
            )
        }
    }
}

@Composable
fun MyLikes(modifier: Modifier = Modifier) {

    var isClicked by rememberSaveable {
        mutableStateOf(false)
    }

    val imagen = if (!isClicked) {
        painterResource(id = R.drawable.ic_like)
    } else {
        painterResource(id = R.drawable.ic_like_filled)
    }
    var numbers by rememberSaveable {
        mutableStateOf(1)
    }

    var colorLike = if (isClicked) Color.Red else Color.Gray

    Box(modifier = modifier
        .fillMaxWidth()) {
        BadgedBox(badge = {
            Text(text = numbers.toString(), color = Color.Gray)
        }) {
            Icon(
                painter = imagen,
                contentDescription = "comment",
                Modifier
                    .size(25.dp)
                    .clickable {
                        isClicked = !isClicked

                        if (isClicked) {
                            numbers++
                        } else {
                            numbers--
                        }

                    },
                tint = colorLike
            )
        }
    }
}