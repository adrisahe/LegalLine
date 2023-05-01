package com.example.legalline.framework.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MessagesQuestions(questions: List<String>, contador: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
    ){
        Card(
            backgroundColor = Color(0xFF79D7E2),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(
                text = questions[contador],
                textAlign = TextAlign.Right,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}