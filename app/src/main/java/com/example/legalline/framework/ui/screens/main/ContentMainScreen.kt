package com.example.legalline.framework.ui.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.legalline.framework.ui.common.MessagesQuestions
import com.example.legalline.framework.ui.common.MessagesResponses
import com.example.legalline.framework.ui.common.WelcomeText
import com.example.legalline.framework.viewmodels.MainViewModel
import kotlinx.coroutines.launch
import java.util.Locale

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ContentMainScreen(mainViewModel: MainViewModel, language: MutableState<Locale>) {
    val responses by mainViewModel.responses.collectAsState()
    val questions by mainViewModel.questions.collectAsState()
    val dialog by mainViewModel.alertDialog.collectAsState()
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
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
                .padding(top = 40.dp, bottom = 40.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = listState
            ) {
                item {
                    WelcomeText(language)
                    if (dialog) {
                        NameFavorite(
                            mainViewModel = mainViewModel,
                            favoritesGestion = { mainViewModel.favoritesGestion() },
                            cancelGestion = { mainViewModel.cancelGestion() }
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
                        NameFavorite(
                            mainViewModel = mainViewModel,
                            favoritesGestion = { mainViewModel.favoritesGestion() },
                            cancelGestion = { mainViewModel.cancelGestion() }
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
                SendText(mainViewModel, language)
            }
            SendButton(mainViewModel)
        }
    }
}