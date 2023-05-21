package com.example.legalline.framework.ui.screens.main

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.legalline.R

@Composable
fun MessagesResponses(conversation: List<String>, contador: Int) {
    var pressed by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.padding(start = 10.dp, end = 60.dp)
    ) {
        Row(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.lawier),
                contentDescription = "Image Bot",
                modifier = Modifier
                    .padding(3.dp)
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, Color(0xFF00ACC1))
            )
            Column(
                modifier = Modifier.padding(end = 10.dp)
            ) {
                Text(
                    text = "Legaline",
                    style = MaterialTheme.typography.h6,
                    fontFamily = FontFamily(Font(R.font.opensans_condensed_bold))
                )
                if (contador == conversation.size) {
                    ThinkingResponse()
                } else {
                    Text(
                        conversation[contador],
                        fontFamily = FontFamily(Font(R.font.opensans_condensed_regular)),
                        color = MaterialTheme.colors.onError,
                    )
                }
            }
        }
    }
}

@Composable
fun ThinkingResponse() {
    val animatedProgress = rememberInfiniteTransition()
        .animateFloat(
            initialValue = 0f,
            targetValue = 4f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        ).value

    val addPoints = buildString {
        repeat(animatedProgress.toInt()) {
            append(".")
        }
    }

    Text(
        text = "Pensando$addPoints",
        modifier = Modifier.defaultMinSize(100.dp),
        fontFamily = FontFamily(Font(R.font.opensans_condensed_regular)),
        color = MaterialTheme.colors.onError,
    )
}