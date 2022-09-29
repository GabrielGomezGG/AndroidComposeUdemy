package com.example.retocopiatuits.TuitScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.retocopiatuits.R

@Composable
fun MyPhotoProfile(modifier: Modifier){

    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "photo profile",
        modifier = modifier
            .clip(CircleShape)
    )
}