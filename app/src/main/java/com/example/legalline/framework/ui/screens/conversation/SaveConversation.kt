package com.example.legalline.framework.ui.screens.conversation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.legalline.framework.ui.common.MessagesQuestions
import com.example.legalline.framework.ui.common.MessagesResponses
import com.example.legalline.framework.ui.common.WelcomeText
import com.example.legalline.framework.viewmodels.ConversationViewModel
import kotlinx.coroutines.launch
import java.util.Locale

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SaveConversation(vm: ConversationViewModel, language: MutableState<Locale>) {
    val responses by vm.listResponses.collectAsState()
    val questions by vm.listQuestions.collectAsState()
    val dialog by vm.alertDialog.collectAsState()
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val textHeight = remember { mutableStateOf(40.dp) }

    val padding: Dp = if (textHeight.value < 75.dp) {
        40.dp
    } else if (textHeight.value < 95.dp) {
        48.dp
    } else if (textHeight.value < 115.dp) {
        57.5.dp
    } else if(textHeight.value < 130.dp){
        67.dp
    } else{
        76.5.dp
    }

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
                .padding(top = padding, bottom = padding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = listState
            ) {
                item {
                    WelcomeText(language)
                    if (dialog) {
                        OverwriteFavorite(
                            vm = vm,
                            cancelGestion = { vm.cancelGestion() }
                        )
                    }
                }
                items(questions.size) { messagesList ->
                    Spacer(modifier = Modifier.size(10.dp))
                    MessagesQuestions(questions, messagesList)
                    Spacer(modifier = Modifier.size(10.dp))
                    MessagesResponses(responses, messagesList)
                    scope.launch {
                        listState.animateScrollToItem(listState.layoutInfo.viewportEndOffset)
                    }
                    if (dialog) {
                        OverwriteFavorite(
                            vm = vm,
                            cancelGestion = { vm.cancelGestion() }
                        )
                    }
                }

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .constrainAs(rowWriteSend) {
                    bottom.linkTo(parent.bottom)
                },
            verticalAlignment = Alignment.Bottom
        ) {
            Box(modifier = Modifier.weight(1f)) {
                SendTextFavorite(vm, language, textHeight)
            }
            SendButton(vm)
        }
    }
}