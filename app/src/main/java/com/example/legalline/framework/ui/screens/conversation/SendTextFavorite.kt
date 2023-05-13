package com.example.legalline.framework.ui.screens.conversation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.legalline.framework.viewmodels.ConversationViewModel
import com.example.legalline.framework.viewmodels.FavoriteViewModel
import com.example.legalline.framework.viewmodels.MainViewModel

@Composable
fun SendTextFavorite(vm: ConversationViewModel) {
    val valueText by vm.valueText.collectAsState()
    TextField(
        value = valueText,
        onValueChange = { vm.updateText(it) },
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = { Text(text = "Mensaje") }
    )
}