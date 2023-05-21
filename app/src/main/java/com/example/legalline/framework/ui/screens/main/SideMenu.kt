package com.example.legalline.framework.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.legalline.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SideMenu(navController: NavHostController, scaffoldState: ScaffoldState, isDarkTheme: MutableState<Boolean>) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.balanza_de_la_justicia),
                contentDescription = "Menu image",
                modifier = Modifier
                    // tengo que coger el tamaño del menu y aplicarselo a la imagen
                    .fillMaxWidth()
                    .graphicsLayer(
                        scaleX = 2.3f,
                        scaleY = 1.7f
                    )
            )
        }
        Spacer(modifier = Modifier.size(47.dp))
        TextButton(onClick = {
            navController.navigate("favorites")
            scope.launch(Dispatchers.Default) {
                scaffoldState.drawerState.close()
            }
        }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.favorites),
                color = MaterialTheme.colors.background
            )
        }
        /*Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = if (isDarkTheme.value) stringResource(id = R.string.dark) else stringResource(id = R.string.light))
            Switch(
                checked = isDarkTheme.value,
                onCheckedChange = { isDarkTheme.value = it },
            )
        }*/
    }
}