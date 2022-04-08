package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footyscores.R
import com.example.footyscores.presentation.ui.theme.Orange
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor

@Composable
fun StatsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 8.dp, end = 8.dp)
    ) {
        MatchPendingTile(R.string.match_pending_stats)
        (0..4).forEach { _ ->
            StatItem("4", "10", "Shots on target")
            Divider(
                color = WhiteAlphaColor,
                thickness = 0.4.dp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Composable
fun StatItem(homeStat: String, awayStat: String, statTitle: String) {
    Column(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    ) {
        val homeStatGreater = homeStat.toInt() > awayStat.toInt()
        val homeProgress = homeStat.toFloat() / (homeStat.toFloat() + awayStat.toFloat())
        val awayProgress = awayStat.toFloat() / (homeStat.toFloat() + awayStat.toFloat())
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 4.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = homeStat,
                style = TextStyle(
                    color = if (homeStatGreater) Color.White else WhiteAlphaColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = statTitle, style = TextStyle(
                    color = if (homeStatGreater) Color.White else WhiteAlphaColor,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = awayStat, style = TextStyle(
                    color = if (!homeStatGreater) Color.White else WhiteAlphaColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
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
                backgroundColor = Color.Black.copy(0.7f),
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
                backgroundColor = Color.Black.copy(0.7f),
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
    StatsScreen()
}
