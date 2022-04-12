package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footyscores.R
import com.example.footyscores.presentation.fixture_details.FixtureDetailsState
import com.example.footyscores.presentation.ui.theme.LatoFont
import com.example.footyscores.presentation.ui.theme.LightGreyColor
import com.example.footyscores.presentation.ui.theme.Orange
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor

@Composable
fun StatsScreen(
    state: FixtureDetailsState,
    nestedScrollConnection: NestedScrollConnection
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 8.dp, end = 8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        val statsAvailable = state.fixtureDetails?.statistics?.isNotEmpty()!!
        if (!statsAvailable) {
            MatchPendingTile(R.string.match_pending_stats)
        } else {
            val homeStatList = state.fixtureDetails.statistics[0].statistics
            val awayStatList = state.fixtureDetails.statistics[1].statistics
            homeStatList.forEachIndexed { index, _ ->
                val nonDigitRegex = Regex("[^0-9.]")
                var homeStat = homeStatList[index].value
                if (homeStat != null) {
                    if (homeStat is String) {
                        homeStat = homeStat.replace(nonDigitRegex, "")
                        homeStat =
                            if (homeStat.contains('.')) homeStat.toDouble().toInt() else homeStat
                    }
                    if (homeStat is Double) {
                        homeStat = homeStat.toInt()
                    }
                } else {
                    homeStat = 0
                }

                var awayStat = awayStatList[index].value
                if (awayStat != null) {
                    if (awayStat is String) {
                        awayStat = awayStat.replace(nonDigitRegex, "")
                        awayStat =
                            if (awayStat.contains('.')) awayStat.toDouble().toInt() else awayStat
                    }
                    if (awayStat is Double) {
                        awayStat = awayStat.toInt()
                    }
                } else {
                    awayStat = 0
                }
                val statType = homeStatList[index].type!!
                StatItem(homeStat.toString().toInt(), awayStat.toString().toInt(), statType)
                Divider(
                    color = WhiteAlphaColor,
                    thickness = 0.4.dp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }

    }
}

@Composable
fun StatItem(homeStat: Int, awayStat: Int, statType: String) {
    Column(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    ) {
        val homeStatGreater = homeStat > awayStat
        val homeProgress = homeStat.toFloat() / (homeStat.toFloat() + awayStat.toFloat())
        val awayProgress = awayStat.toFloat() / (homeStat.toFloat() + awayStat.toFloat())
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 8.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "$homeStat",
                style = TextStyle(
                    color = if (homeStatGreater) Color.White else WhiteAlphaColor,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = LatoFont.fontFamily
                )
            )
            Text(
                text = statType, style = TextStyle(
                    color = WhiteAlphaColor,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = LatoFont.fontFamily
                )
            )
            Text(
                text = "$awayStat",
                style = TextStyle(
                    color = if (!homeStatGreater) Color.White else WhiteAlphaColor,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = LatoFont.fontFamily
                )
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 4.dp)
                .fillMaxWidth()
        ) {
            LinearProgressIndicator(
                progress = (homeProgress),
                color = if (homeStatGreater) Orange else Color.LightGray,
                backgroundColor = LightGreyColor,
                modifier = Modifier
                    .scale(-1f)
                    .weight(1f)
                    .height(8.dp)
                    .clip(
                        shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp),
                    )
            )
            Spacer(modifier = Modifier.width(5.dp))
            LinearProgressIndicator(
                progress = awayProgress,
                color = if (!homeStatGreater) Orange else Color.LightGray,
                backgroundColor = LightGreyColor,
                modifier = Modifier
                    .weight(1f)
                    .height(8.dp)
                    .clip(
                        shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp),
                    )
            )
        }
    }
}

@Preview
@Composable
fun StatsPrev() {
//    StatsScreen(FixtureDetailsState(), lazyListState, nestedScrollConnection)
}
