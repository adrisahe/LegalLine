package com.example.legalline.View.MainScreen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import com.example.legalline.ViewModel.MainViewModel.MainViewModel

@Composable
fun SendButton(mainViewModel: MainViewModel) {
    IconButton(
        onClick = { mainViewModel.questionAndResponse() },
    ) {
        Icon(
            Icons.Default.Send,
            contentDescription = "Send Button"
        )
    }
}