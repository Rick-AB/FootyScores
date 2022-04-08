package com.example.footyscores.presentation.fixture_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footyscores.presentation.fixture_details.components.FixtureDetailsScreen

@Composable
fun FixtureDetailsFragment(
    navController: NavController,
    fixtureId: Int,
    homeTeamName: String,
    homoTeamLogo: String,
    awayTeamName: String,
    awayTeamLogo: String,
    date: String,
    time: String
) {
    val fixtureDetailsViewModel: FixtureDetailsViewModel = hiltViewModel()
    val state = fixtureDetailsViewModel.state.value
    LaunchedEffect(key1 = fixtureId) {
        fixtureDetailsViewModel.getFixtureById(fixtureId)
    }
    FixtureDetailsScreen(
        state = state,
        navController = navController,
        homeTeamName = homeTeamName,
        homoTeamLogo = homoTeamLogo,
        awayTeamName = awayTeamName,
        awayTeamLogo = awayTeamLogo,
        date = date,
        time = time
    )
}