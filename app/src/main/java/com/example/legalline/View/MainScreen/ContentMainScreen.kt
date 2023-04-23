package com.example.legalline.View.MainScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.legalline.ViewModel.MainViewModel.MainViewModel

@Composable
fun ContentMainScreen(mainViewModel: MainViewModel) {
    val conversation = mainViewModel.conversation.collectAsState()
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (lazyColumnMessages, rowWriteSend) = createRefs()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(lazyColumnMessages) {
                    top.linkTo(parent.top)
                    bottom.linkTo(rowWriteSend.top)
                }
                .padding(10.dp)
        ){
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ){
                items(conversation.value.size){messagesList->
                    MessagesConversation(conversation, messagesList)
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .constrainAs(rowWriteSend) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Box(modifier = Modifier.weight(1f)) {
                SendText(mainViewModel)
            }
            SendButton(mainViewModel)
        }
    }
}