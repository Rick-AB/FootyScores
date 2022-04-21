package com.example.footyscores.presentation.favoritefixtures.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.footyscores.R
import com.example.footyscores.presentation.Screens
import com.example.footyscores.presentation.favoritefixtures.FavoriteFixturesState
import com.example.footyscores.presentation.fixture_list.FixtureListEvent
import com.example.footyscores.presentation.fixture_list.components.FixtureListItem
import com.example.footyscores.presentation.fixture_list.components.SectionHeader
import com.example.footyscores.presentation.ui.theme.LatoFont
import java.net.URLEncoder

@Composable
fun FavoriteFixturesScreen(
    navController: NavController,
    state: FavoriteFixturesState,
    onEvent: (FixtureListEvent) -> Unit
) {
    val favoriteFixtures = state.data
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        item {
            if (favoriteFixtures.isEmpty()) {
                Box(modifier = Modifier.fillParentMaxSize()) {
                    Text(
                        text = stringResource(id = R.string.no_saved_fixtures),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = LatoFont.fontFamily,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }

        val groupedByCountry = favoriteFixtures.groupBy { it.league.country }
        groupedByCountry.forEach { (_, fixtures) ->
            val groupedById = fixtures.groupBy { it.league.id }
            groupedById.forEach { (_, fixtures) ->
                item { SectionHeader(fixtures[0].league) }
                items(fixtures) {
                    val onItemClick: () -> Unit = {
                        val encodedHomeLogoUrl = URLEncoder.encode(it.teams.home.logo, "UTF-8")
                        val encodedAwayLogoUrl = URLEncoder.encode(it.teams.away.logo, "UTF-8")
                        navController.navigate(
                            route = Screens.FixtureDetailsScreen.buildRoute(
                                Screens.FixtureDetailsScreen.name,
                                "${it.fixture.id}",
                                it.teams.home.name!!,
                                encodedHomeLogoUrl,
                                it.teams.away.name!!,
                                encodedAwayLogoUrl,
                                it.fixture.date,
                                "${it.fixture.timestamp!!}"
                            )
                        )
                    }
                    FixtureListItem(
                        matchInfo = it,
                        onClick = onItemClick,
                        onEvent = onEvent,
                        modifier = Modifier.animateItemPlacement()
                    )
                }
            }
        }
    }
}