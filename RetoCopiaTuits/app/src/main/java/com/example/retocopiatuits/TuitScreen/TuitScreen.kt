package com.example.retocopiatuits.TuitScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyTuitScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)) {
        Row(modifier = Modifier
            .padding(8.dp)) {
            MyPhotoProfile()
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                MyAutorTuit()
                Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", color = Color.White)
                MyPhotoPost(Modifier.padding(vertical = 10.dp))
                Row(
                    Modifier.fillMaxWidth(),
                ) {
                    MyComents(Modifier.weight(1f))
                    MyRT(Modifier.weight(1f))
                    MyLikes(Modifier.weight(1f))
                }
            }
        }
        Divider(
            color = Color.Gray,
            thickness = 2.dp,
            modifier = Modifier.padding(vertical = 8.dp)
                .alpha(0.4f)
        )
        Row(modifier = Modifier
            .padding(8.dp)) {
            MyPhotoProfile()
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                MyAutorTuit()
                Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", color = Color.White)
                MyPhotoPost(Modifier.padding(vertical = 10.dp))
                Row(
                    Modifier.fillMaxWidth(),
                ) {
                    MyComents(Modifier.weight(1f))
                    MyRT(Modifier.weight(1f))
                    MyLikes(Modifier.weight(1f))
                }
            }
        }
        Row(modifier = Modifier
            .padding(8.dp)) {
            MyPhotoProfile()
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                MyAutorTuit()
                Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", color = Color.White)
                MyPhotoPost(Modifier.padding(vertical = 10.dp))
                Row(
                    Modifier.fillMaxWidth(),
                ) {
                    MyComents(Modifier.weight(1f))
                    MyRT(Modifier.weight(1f))
                    MyLikes(Modifier.weight(1f))
                }
            }
        }
    }


}