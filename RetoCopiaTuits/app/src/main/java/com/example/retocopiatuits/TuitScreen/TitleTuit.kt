package com.example.retocopiatuits.TuitScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.retocopiatuits.R

@Composable
fun MyAutorTuit(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Aris",
            Modifier
                .padding(horizontal = 2.dp),
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "@AristiDevs",
            Modifier.padding(horizontal = 2.dp),
            fontWeight = FontWeight.Light,
            color = Color.White
        )
        //Spacer(modifier = modifier.size(2.dp))
        Text(
            text = "4s",
            Modifier.padding(horizontal = 2.dp).weight(1f),
            fontWeight = FontWeight.Light,
            color = Color.White,
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = null,
            tint = Color.White
        )
    }
}