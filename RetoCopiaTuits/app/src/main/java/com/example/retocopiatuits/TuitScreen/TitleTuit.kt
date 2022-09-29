package com.example.retocopiatuits.TuitScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.retocopiatuits.R

@Composable
fun MyAutorTuit(modifier: Modifier = Modifier) {

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Aris",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "@AristiDevs",
                Modifier.padding(horizontal = 2.dp),
                fontWeight = FontWeight.Light,
                color = Color.White
            )
            Text(
                text = "4s",
                Modifier
                    .padding(horizontal = 2.dp)
                    .weight(1f),
                fontWeight = FontWeight.Light,
                color = Color.White,
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "options",
                tint = Color.White
            )
        }

}