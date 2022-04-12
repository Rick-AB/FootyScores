package com.example.footyscores.presentation.fixture_list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.footyscores.common.getDayOfMonth
import com.example.footyscores.common.getDayOfWeek
import com.example.footyscores.common.getMonthOfYear
import com.example.footyscores.presentation.fixture_list.components.FixtureListScreen
import com.example.footyscores.presentation.ui.theme.LatoFont
import com.example.footyscores.presentation.ui.theme.Orange
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun TabScreens(
    navController: NavController,
    mainViewModel: FixtureListViewModel,
    innerPadding: PaddingValues
) {
    val pagerState = mainViewModel.pagerState
    val dateRanges by remember {
        mutableStateOf(mainViewModel.dateRanges)
    }
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
        TabRow(selectedTabIndex = tabIndex, indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(
                    pagerState,
                    tabPositions
                ),
                height = 1.dp,
                color = Orange
            )
        }) {
            dateRanges.forEachIndexed { index, timestamp ->
                val dayOfWeek = getDayOfWeek(timestamp)
                val dayOfMonth = getDayOfMonth(timestamp)
                val monthOfYear = getMonthOfYear(timestamp)
                Tab(
                    selected = tabIndex == index,
                    selectedContentColor = Orange,
                    unselectedContentColor = Color.White,
                    onClick = {
                        coroutineScope.launch { pagerState.scrollToPage(index) }
                    },
                    text = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = dayOfWeek,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = LatoFont.fontFamily
                                )
                            )

                            Text(
                                text = "$dayOfMonth $monthOfYear",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = LatoFont.fontFamily
                                )
                            )
                        }
                    })
            }
        }

        HorizontalPager(
            count = dateRanges.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) {
            FixtureListScreen(
                navController = navController,
                state = mainViewModel.state.value,
                mainViewModel::refreshData
            )
        }
    }
}