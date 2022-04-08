package com.example.footyscores.presentation.fixture_details.components

import android.app.Activity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.footyscores.presentation.fixture_details.FixtureDetailsState
import com.example.footyscores.presentation.ui.theme.Orange

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FixtureDetailsScreen(
    state: FixtureDetailsState,
    navController: NavController,
    homeTeamName: String,
    homoTeamLogo: String,
    awayTeamName: String,
    awayTeamLogo: String,
    date: String,
    time: String
) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ChevronLeft,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            MatchInfoHeader(
                homeTeamName,
                homoTeamLogo,
                awayTeamName,
                awayTeamLogo,
                date,
                time
            )
            Spacer(modifier = Modifier.height(8.dp))
            AnimatedVisibility(visible = state.loading, exit = fadeOut(animationSpec = tween(1500))) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = Orange)
                }
            }
            AnimatedVisibility(visible = !state.loading, enter = fadeIn(animationSpec = tween(1000))) {
                TabItems()
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    FixtureDetailsScreen(
        state = FixtureDetailsState(),
        navController = NavController(Activity()),
        homeTeamName = "United",
        homoTeamLogo = "",
        awayTeamName = "City",
        awayTeamLogo = "",
        date = "Today",
        time = "4:15"
    )
}