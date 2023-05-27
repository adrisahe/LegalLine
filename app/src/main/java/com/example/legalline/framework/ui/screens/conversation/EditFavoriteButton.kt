package com.example.legalline.framework.ui.screens.conversation

import android.util.Log
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.legalline.R
import com.example.legalline.framework.viewmodels.ConversationViewModel

@Composable
fun EditFavoriteButton(vm: ConversationViewModel) {
    IconButton(onClick = {
        vm.showDialog()
    }) {
        Icon(
            painter = painterResource(id = R.drawable.edit_favorite),
            contentDescription = stringResource(id = R.string.EditFavoriteDescription)
        )
    }
}