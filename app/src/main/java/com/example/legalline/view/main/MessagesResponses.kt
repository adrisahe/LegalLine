package com.example.legalline.view.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.legalline.R

@Composable
fun MessagesResponses(conversation: List<String>, contador: Int) {
    Card(
        shape = RoundedCornerShape(30.dp)
    ) {
        Row{
            Image(
                painter = painterResource(id = R.drawable.lawier),
                contentDescription = "Image Bot",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, Color(0xFF00ACC1))
            )
            Column(
                modifier = Modifier.padding(end = 10.dp)
            ) {
                Text(
                    text = "Legaline",
                    style = MaterialTheme.typography.h6
                    )
                Text(conversation[contador])
            }
        }
    }
}