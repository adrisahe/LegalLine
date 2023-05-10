package com.example.legalline.framework.ui.screens.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.legalline.R
import com.example.legalline.framework.viewmodels.FavoriteViewModel

@Composable
fun ContentFavorites(vm: FavoriteViewModel, navController: NavHostController) {
    val favorites by vm.favorites.collectAsState()
    LazyColumn {
        items(favorites.size){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(
                            "favoritesConver/${favorites[it].idNameConversation}"
                        )
                    }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 5.dp),
                        text = favorites[it].idNameConversation,
                        fontFamily = FontFamily(Font(R.font.opensans_condensed_regular))
                    )
                    IconButton(onClick = {
                        vm.removeFavorite(
                            favorites[it].idNameConversation,
                            favorites[it].responses,
                            favorites[it].questions
                        )
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.trash),
                            contentDescription = "trash image",
                            tint = colorResource(id = R.color.blueTrash)
                        )
                    }
                }
            }
        }
    }
}