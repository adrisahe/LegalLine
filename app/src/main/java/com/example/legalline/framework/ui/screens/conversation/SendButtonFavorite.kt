package com.example.legalline.framework.ui.screens.conversation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.legalline.framework.viewmodels.ConversationViewModel
import com.example.legalline.framework.viewmodels.MainViewModel

@Composable
fun SendButton(vm: ConversationViewModel) {
    val loading by vm.loading.collectAsState()
    IconButton(
        onClick = { vm.questionAndResponse() },
        modifier = Modifier.padding(bottom = 15.dp),
        enabled = !loading
    ) {
        Icon(
            Icons.Default.Send,
            contentDescription = "Send Button",
            tint = Color(0xFFFFFFFF),
            modifier = Modifier
                .background(Color(0xFF00897B), CircleShape)
                .size(42.dp)
                .padding(start = 10.dp, end = 6.dp, top = 6.dp, bottom = 6.dp)
        )
    }
}