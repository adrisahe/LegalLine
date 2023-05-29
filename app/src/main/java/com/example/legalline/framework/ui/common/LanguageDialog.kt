package com.example.legalline.framework.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.legalline.R
import java.util.Locale


@Composable
fun LanguageDialog(languageDialog: MutableState<Boolean>, language: MutableState<Locale>) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(
                text = stringResource(id = R.string.titlelanguageDialog),
                fontFamily = FontFamily(Font(R.font.opensans_condensed_regular)),
                color = MaterialTheme.colors.onError,
            ) },
            text = {
                Text(
                    text = stringResource(id = R.string.descriptionLanguageDialog),
                    fontFamily = FontFamily(Font(R.font.opensans_condensed_regular)),
                    color = MaterialTheme.colors.onError,
                )
            },
            buttons = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Top
                ) {
                    TextButton(onClick = {
                        language.value = Locale.forLanguageTag("es")
                        languageDialog.value = false
                    }) {
                        Text(
                            text = stringResource(id = R.string.spanish),
                            fontFamily = FontFamily(Font(R.font.opensans_condensed_regular)),
                            color = MaterialTheme.colors.onError,
                        )
                    }
                    TextButton(onClick =  {
                        language.value = Locale.ENGLISH
                        languageDialog.value = false
                    } ) {
                        Text(
                            text = stringResource(id = R.string.english),
                            fontFamily = FontFamily(Font(R.font.opensans_condensed_regular)),
                            color = MaterialTheme.colors.onError,
                        )
                    }
                }
            }
        )
    }
}