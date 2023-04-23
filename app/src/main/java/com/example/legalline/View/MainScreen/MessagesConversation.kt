package com.example.legalline.View.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.legalline.R

@Composable
fun MessagesConversation(conversation: State<List<String>>, contador: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Image Bot")
            Column {
                Text(text = "Legaline")
                Text(conversation.value[contador])
            }
        }
        
    }


}