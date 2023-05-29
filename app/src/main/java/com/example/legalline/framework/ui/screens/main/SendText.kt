package com.example.legalline.framework.ui.screens.main

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.legalline.R
import com.example.legalline.data.utils.updateLanguage
import com.example.legalline.framework.viewmodels.MainViewModel
import java.util.Locale

@Composable
fun SendText(mainViewModel: MainViewModel, language: MutableState<Locale>, textHeight: MutableState<Dp>) {
    val valueText by mainViewModel.valueText.collectAsState()
    val density = LocalDensity.current
    TextField(
        value = valueText,
        onValueChange = { mainViewModel.updateText(it) },
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.opensans_condensed_regular))
        ),
        shape = RoundedCornerShape(30.dp),
        maxLines = 5,
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                with(density){
                    textHeight.value = it.size.height.toDp()
                }
            }
            .padding(bottom = 10.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colors.onError
        ),
        placeholder = {
            updateLanguage(LocalContext.current, language)
            Text(
                text = stringResource(id = R.string.placeholderMessage),
                fontFamily = FontFamily(Font(R.font.opensans_condensed_regular))
            )
        }
    )
}