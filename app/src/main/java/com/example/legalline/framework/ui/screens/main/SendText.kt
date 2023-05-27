package com.example.legalline.framework.ui.screens.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.legalline.R
import com.example.legalline.data.utils.updateLanguage
import com.example.legalline.framework.viewmodels.MainViewModel
import java.util.Locale

@Composable
fun SendText(mainViewModel: MainViewModel, language: MutableState<Locale>) {
    val valueText by mainViewModel.valueText.collectAsState()
    TextField(
        value = valueText,
        onValueChange = { mainViewModel.updateText(it) },
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            updateLanguage(LocalContext.current, language)
            Text(text = stringResource(id = R.string.placeholderMessage))
        }
    )
}