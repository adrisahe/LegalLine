package com.example.legalline.View.MainScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.legalline.ViewModel.MainViewModel.MainViewModel

@Composable
fun ContentMainScreen(mainViewModel: MainViewModel) {
    val responses by mainViewModel.responses.collectAsState()
    val questions by mainViewModel.questions.collectAsState()
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
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 40.dp, bottom = 80.dp, start = 10.dp, end = 10.dp)
        ){
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ){
                item {
                    WelcomeText()
                }
                items(responses.size){messagesList->
                    Spacer(modifier = Modifier.size(10.dp))
                    MessagesQuestions(questions, messagesList)
                    Spacer(modifier = Modifier.size(10.dp))
                    MessagesResponses(responses, messagesList)
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