package com.example.retocopiatuits.TuitScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.retocopiatuits.R

@Composable
fun MyPhotoProfile(modifier: Modifier = Modifier){

    Box(modifier = modifier.size(60.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "photo profile",
            Modifier.clip(CircleShape)
        )
    }
}