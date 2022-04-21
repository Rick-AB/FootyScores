package com.example.footyscores.presentation.favoritefixtures

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footyscores.presentation.favoritefixtures.components.FavoriteFixturesScreen

@Composable
fun FavoriteFixturesFragment(navController: NavController, innerPadding: PaddingValues) {
    val viewModel: FavoriteFixturesViewModel = hiltViewModel()
    Column(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
        FavoriteFixturesScreen(
            navController = navController,
            state = viewModel.state.value,
            onEvent = viewModel::onEvent
        )
    }
}