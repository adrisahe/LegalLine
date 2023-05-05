package com.example.legalline.framework.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun NameFavorite(reloadFichas: () -> Unit,) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Nombre") },
            text = { Text(text = "Introduce el nombre de la conversacion") },
            buttons = {
                TextButton(onClick =  reloadFichas ) {
                    Text(
                        text = "Añadir",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Left
                    )
                }
                TextButton(onClick =  reloadFichas ) {
                    Text(
                        text = "Cancelar",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right
                    )
                }
            }
        )
    }
}