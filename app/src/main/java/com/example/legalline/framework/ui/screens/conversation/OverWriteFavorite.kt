package com.example.legalline.framework.ui.screens.conversation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.legalline.R
import com.example.legalline.framework.viewmodels.ConversationViewModel
import com.example.legalline.framework.viewmodels.MainViewModel

@Composable
fun OverwriteFavorite(
    vm: ConversationViewModel,
    favoritesGestion: () -> Unit,
    cancelGestion: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(
                text = stringResource(id = R.string.overwriteTitle),
            ) },
            text = { 
                   Text(text = stringResource(id = R.string.overwriteDescription))
            },
            buttons = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Top
                ) {
                    TextButton(onClick = { vm.overwritteFavorite() }) {
                        Text(
                            text = stringResource(id = R.string.addFavorite),
                            fontFamily = FontFamily(Font(R.font.opensans_condensed_regular))
                        )
                    }
                    TextButton(onClick =  cancelGestion ) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                        )
                    }
                }

            }
        )
    }
}