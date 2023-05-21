package com.example.legalline.framework.ui.screens.main

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.legalline.R

@Composable
fun WelcomeText() {
    var isLongPressed by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp, end = 60.dp)
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
                    text = stringResource(id = R.string.legaline),
                    style = MaterialTheme.typography.h6,
                    fontFamily = FontFamily(Font(R.font.opensans_condensed_bold))
                )
                Text(
                    stringResource(id = R.string.welcomeMessage),
                    fontFamily = FontFamily(Font(R.font.opensans_condensed_regular))
                )
            }
        }
    }
    if (isLongPressed){
        Toast.makeText(LocalContext.current, "textoCopias", Toast.LENGTH_LONG).show()
        isLongPressed = false
    }
}