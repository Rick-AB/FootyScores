package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footyscores.R
import com.example.footyscores.presentation.fixture_details.FixtureDetailsState
import com.example.footyscores.presentation.ui.theme.Black
import com.example.footyscores.presentation.ui.theme.LatoFont
import com.example.footyscores.presentation.ui.theme.Orange
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun TabItems(
    state: FixtureDetailsState,
    lazyListState: LazyListState,
    nestedScrollConnection: NestedScrollConnection
) {
    val tabs = remember {
        mutableStateListOf(R.string.info, R.string.summary, R.string.stats, R.string.lineups)
    }
    val pagerState = rememberPagerState(initialPage = 0)
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(
            backgroundColor = Color.Transparent,
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(
                        pagerState,
                        tabPositions
                    ),
                    height = 0.5.dp,
                    color = Black
                )
            }) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = index == tabIndex,
                    selectedContentColor = Orange,
                    unselectedContentColor = Color.White,
                    onClick = {
                        coroutineScope.launch { pagerState.scrollToPage(index) }
                    },
                    text = {
                        Text(
                            text = stringResource(id = tab),
                            style = TextStyle(
                                color = if (index == tabIndex) Orange else WhiteAlphaColor,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = LatoFont.fontFamily
                            )
                        )
                    })
            }
        }

        HorizontalPager(count = tabs.size, state = pagerState, modifier = Modifier.weight(1f)) {
            when (this.currentPage) {
                0 -> InfoScreen(state, nestedScrollConnection)
                1 -> SummaryScreen(state, nestedScrollConnection)
                2 -> StatsScreen(state, nestedScrollConnection)
                3 -> LineupsScreen(state, nestedScrollConnection)
            }
        }
    }
}