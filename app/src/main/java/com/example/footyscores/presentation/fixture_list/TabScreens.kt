package com.example.footyscores.presentation.fixture_list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.example.footyscores.data.remote.dto.ResponseDto
import com.example.footyscores.presentation.ui.theme.Orange
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

@ExperimentalCoilApi
@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun TabScreens() {
    val ranges = getDateRanges()
    val pagerState = rememberPagerState(initialPage = 2)
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column {
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
            ranges.forEachIndexed { index, timestamp ->
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
                        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = dayOfWeek,
                                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            )

                            Text(
                                text = "$dayOfMonth $monthOfYear" ,
                                style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            )
                        }
                    })
            }
        }

        HorizontalPager(count = ranges.size, state = pagerState, modifier = Modifier.weight(1f)) {
            val fixtures = ArrayList<ResponseDto>()
            for (i in 0..30) {
                fixtures.add(ResponseDto())
            }
            FixtureListScreen(ranges[pagerState.currentPage])
        }
    }
}

private fun getMonthOfYear(timestamp: Long): String {
    val cal = Calendar.getInstance()
    cal.timeInMillis = timestamp
    return cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())!!
}

private fun getDayOfMonth(timestamp: Long): String {
    val cal = Calendar.getInstance()
    cal.timeInMillis = timestamp
    return cal.get(Calendar.DAY_OF_MONTH).toString()
}

private fun getDayOfWeek(timestamp: Long): String {
    val cal = Calendar.getInstance()
    cal.timeInMillis = timestamp
    return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault())!!
}

private fun getDateRanges(): List<Long> {
    val dateRanges = ArrayList<Long>()
    for (i in -2..2) {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, i)
        dateRanges.add(cal.timeInMillis)
    }

    return dateRanges
}
