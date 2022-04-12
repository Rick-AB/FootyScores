package com.example.footyscores.presentation.fixture_details.components

import android.app.Activity
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.footyscores.common.Constants
import com.example.footyscores.common.getTimeFromDateString
import com.example.footyscores.presentation.fixture_details.FixtureDetailsState
import com.example.footyscores.presentation.ui.theme.LatoFont
import com.example.footyscores.presentation.ui.theme.Orange
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlin.math.roundToInt

@Composable
fun FixtureDetailsScreen(
    state: FixtureDetailsState,
    navController: NavController,
    homeTeamName: String,
    homoTeamLogo: String,
    awayTeamName: String,
    awayTeamLogo: String,
    date: String,
    onRefresh: () -> Unit
) {
    val context = LocalContext.current
    val navBarInfoHeight = 110.dp
    val navBarInfoHeightPx = with(LocalDensity.current) { navBarInfoHeight.roundToPx().toFloat() }
    val navBarInfoOffsetHeightPx = remember { mutableStateOf(150f) }
    val lazyListState = rememberLazyListState()
    val nestedScrollConnection = object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            val delta = available.y
            val newOffset = navBarInfoOffsetHeightPx.value + delta
            navBarInfoOffsetHeightPx.value = newOffset.coerceIn(0f, navBarInfoHeightPx)
            return Offset.Zero
        }
    }
    val navBarInfoAlpha = animateFloatAsState(
        targetValue = when (navBarInfoOffsetHeightPx.value.roundToInt()) {
            in 0..10 -> 1f
            in 11..20 -> 0.8f
            in 21..30 -> 0.7f
            in 31..40 -> 0.6f
            in 41..50 -> 0.5f
            in 51..60 -> 0.4f
            else -> 0f
        }
    )

    LaunchedEffect(key1 = state.error) {
        if (!state.error.isNullOrEmpty()) {
            Toast.makeText(context, state.error, Toast.LENGTH_LONG).show()
        }
    }
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.ChevronLeft,
                    contentDescription = "",
                    tint = Color.White
                )
            }

            AnimatedHeader(
                homoTeamLogo,
                awayTeamLogo,
                modifier = Modifier
                    .align(Alignment.Center)
                    .alpha(navBarInfoAlpha.value)
                    .offset { IntOffset(x = 0, -navBarInfoOffsetHeightPx.value.roundToInt()) },
                date,
                state
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(nestedScrollConnection),
            state = lazyListState
        ) {
            item {
                MatchInfoHeader(
                    state,
                    homeTeamName,
                    homoTeamLogo,
                    awayTeamName,
                    awayTeamLogo,
                    date,
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                AnimatedVisibility(visible = state.loading) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillParentMaxSize()
                    ) {
                        CircularProgressIndicator(color = Orange)
                    }


                }
                AnimatedVisibility(visible = !state.loading) {
                    Box(
                        modifier = Modifier
                            .fillParentMaxSize()
                    ) {
                        SwipeRefresh(
                            indicatorPadding = PaddingValues(top = 50.dp),
                            state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
                            onRefresh = { onRefresh() }) {
                            TabItems(state, lazyListState, nestedScrollConnection)
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun AnimatedHeader(
    homoTeamLogo: String,
    awayTeamLogo: String,
    modifier: Modifier,
    date: String,
    state: FixtureDetailsState
) {
    val matchStatusShort = state.fixtureDetails?.fixture?.status?.short
    val homeGoal = state.fixtureDetails?.goals?.home
    val awayGoal = state.fixtureDetails?.goals?.away
    val infoText = when (matchStatusShort) {
        Constants.NOT_START -> getTimeFromDateString(date)
        else -> "$homeGoal - $awayGoal"
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        val homeTeamCoilPainter = rememberCoilPainter(request = homoTeamLogo)
        val awayTeamCoilPainter = rememberCoilPainter(request = awayTeamLogo)
        Image(
            painter = homeTeamCoilPainter, contentDescription = "", modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = if (state.loading) getTimeFromDateString(date) else infoText,
            style = TextStyle(Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold,
                fontFamily = LatoFont.fontFamily),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = awayTeamCoilPainter, contentDescription = "", modifier = Modifier.size(32.dp)
        )
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
        date = "Today"
    ) {}
}