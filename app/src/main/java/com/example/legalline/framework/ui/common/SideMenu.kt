package com.example.legalline.framework.ui.common

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.legalline.R
import com.example.legalline.framework.ui.common.LanguageDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SideMenu(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    isDarkTheme: MutableState<Boolean>,
    language: MutableState<java.util.Locale>
) {
    val scope = rememberCoroutineScope()
    val languageDialog = remember{ mutableStateOf(false) }
    val orientation = LocalConfiguration.current.orientation
    val scaleX = if (orientation == 1){
        2.3f
    }  else {
        5.1f
    }
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
                contentDescription = stringResource(id = R.string.imageJustice),
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer(
                        scaleX = scaleX,
                        scaleY = 1.7f
                    )
            )
        }
        Spacer(modifier = Modifier.size(60.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("favorites")
                    scope.launch(Dispatchers.Main) {
                        scaffoldState.drawerState.close()
                    }
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.favorites),
                fontFamily = FontFamily(Font(R.font.opensans_condensed_bold)),
                color = MaterialTheme.colors.onError,
                modifier = Modifier.padding(start = 9.dp)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.iconArrow)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .clickable {
                    languageDialog.value = true
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.language),
                fontFamily = FontFamily(Font(R.font.opensans_condensed_bold)),
                color = MaterialTheme.colors.onError,
                modifier = Modifier.padding(start = 9.dp)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.iconArrow)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .height(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (isDarkTheme.value) stringResource(id = R.string.dark) else stringResource(id = R.string.light),
                fontFamily = FontFamily(Font(R.font.opensans_condensed_bold)),
                color = MaterialTheme.colors.onError,
                modifier = Modifier.padding(start = 9.dp)
            )
            Switch(
                checked = isDarkTheme.value,
                onCheckedChange = { isDarkTheme.value = it },
            )
        }
    }
    if (languageDialog.value){
        LanguageDialog(languageDialog, language)
    }
}