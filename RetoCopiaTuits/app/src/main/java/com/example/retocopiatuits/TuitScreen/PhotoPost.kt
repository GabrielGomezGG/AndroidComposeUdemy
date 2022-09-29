package com.example.retocopiatuits.TuitScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.retocopiatuits.R

@Composable
fun MyPhotoPost(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "post",
        modifier = modifier.clip(RoundedCornerShape(15.dp))
    )
}