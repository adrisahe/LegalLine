package com.example.legalline.framework.ui.screens.main

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.legalline.R
import com.example.legalline.framework.viewmodels.MainViewModel
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NameFavorite(
    mainViewModel: MainViewModel,
    favoritesGestion: () -> Unit,
    cancelGestion: () -> Unit
) {
    val dialogText by mainViewModel.dialogText.collectAsState()
    val error by mainViewModel.addError.collectAsState()
    AlertDialog(
        onDismissRequest = {},
        title = { Text(
            text = stringResource(id = R.string.dialogTitle),
        ) },
        text = { TextField(
            value = dialogText,
            onValueChange = {mainViewModel.updateDialogText(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = { Text(text = "Nombre conversación")},
            textStyle = MaterialTheme.typography.body1,
            isError = error,
        ) },
        buttons = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top
            ) {
                TextButton(onClick = {
                    favoritesGestion()
                }) {
                    Text(
                        text = stringResource(id = R.string.saveFavorite),
                        fontFamily = FontFamily(Font(R.font.opensans_condensed_regular)),
                        color = MaterialTheme.colors.onError,
                    )
                }
                TextButton(onClick =  cancelGestion ) {
                    Text(
                        text = stringResource(id = R.string.cancel),
                        fontFamily = FontFamily(Font(R.font.opensans_condensed_regular)),
                        color = MaterialTheme.colors.onError
                    )
                }
            }
        }
    )
}