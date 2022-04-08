package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footyscores.R
import com.example.footyscores.presentation.ui.theme.Black
import com.example.footyscores.presentation.ui.theme.Orange
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabItems() {
    val tabs = listOf(R.string.info, R.string.summary,  R.string.stats, R.string.lineups)
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column {
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
                                fontWeight = FontWeight.Bold
                            )
                        )
                    })
            }
        }

        HorizontalPager(count = tabs.size, state = pagerState, modifier = Modifier.weight(1f)) {
            when (pagerState.currentPage) {
                0 -> InfoScreen()
                1 -> SummaryScreen()
                2 -> StatsScreen()
                3 -> LineupsScreen()
            }
        }
    }
}