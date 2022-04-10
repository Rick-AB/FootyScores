package com.example.footyscores.presentation.fixture_list.components

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.footyscores.presentation.Screens
import com.example.footyscores.presentation.fixture_list.FixtureListState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import java.net.URLEncoder

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun FixtureListScreen(
    navController: NavController,
    state: FixtureListState,
    onRefresh: () -> Unit,
) {
    val fixtures = state.fixtures.sortedBy { it.league.id }
    val context = LocalContext.current
    LaunchedEffect(key1 = state.error) {
        if (!state.error.isNullOrEmpty()) {
            Toast.makeText(context, state.error, Toast.LENGTH_LONG).show()
        }
    }
    SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing), onRefresh = {
        onRefresh()
    }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            val groupedByCountry = fixtures.groupBy { it.league.country }
            groupedByCountry.forEach { (_, fixtures) ->
                val groupedById = fixtures.groupBy { it.league.id }
                groupedById.forEach { (_, fixtures) ->
                    item { SectionHeader(fixtures[0].league) }
                    items(fixtures) {
                        FixtureListItem(it) {
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
                    }
                }
            }
        }
    }
}