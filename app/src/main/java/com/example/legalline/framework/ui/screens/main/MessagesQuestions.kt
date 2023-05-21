package com.example.legalline.framework.ui.screens.main

import android.content.ClipData
import android.content.res.Resources.Theme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.legalline.R

@Composable
fun MessagesQuestions(questions: List<String>, contador: Int) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.secondaryVariant,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(start = 60.dp, end = 10.dp)
                .wrapContentSize()
        ) {
            Text(
                text = questions[contador],
                textAlign = TextAlign.Left,
                fontFamily = FontFamily(Font(R.font.opensans_condensed_regular)),
                color = MaterialTheme.colors.onError,
                modifier = Modifier.padding(10.dp)
            )
        }
    }

}