package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footyscores.R
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor

@Composable
fun LineupsScreen() {
    Column(
        modifier = Modifier
            .padding(bottom = 20.dp, start = 8.dp, end = 8.dp)
            .fillMaxSize()
    ) {
        val homeXI = listOf(
            "De Gea",
            "Luke Shaw",
            "Varane",
            "Ronaldo",
            "Fred",
            "Bruno Fernandez",
            "Sancho",
            "Maguire",
            "Paul Pogba",
            "Dalot",
            "Rashford"
        )
        val awayXI = listOf(
            "De Gea",
            "Luke Shaw",
            "Varane",
            "Ronaldo",
            "Fred",
            "Bruno Fernandez",
            "Sancho",
            "Maguire",
            "Paul Pogba",
            "Dalot",
            "Rashford"
        )
        Formations("4-3-2-1", "4-3-3")
        Spacer(modifier = Modifier.height(16.dp))
        StartingXI(homeXI = homeXI, awayXI = awayXI)
        Spacer(modifier = Modifier.height(16.dp))
        Substitutes(homeSubs = homeXI.subList(0, 7), awaySubs = awayXI.subList(0, 7))
        Spacer(modifier = Modifier.height(16.dp))
        Coaches(homeCoach = "Ralph Ragnarok", awayCoach = "O. Soljker")
    }
}

@Composable
fun Substitutes(homeSubs: List<String>, awaySubs: List<String>) {
    Text(
        text = stringResource(id = R.string.substitute_players).uppercase(),
        style = TextStyle(
            color = WhiteAlphaColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(0.4.dp, WhiteAlphaColor, RoundedCornerShape(8.dp))
    ) {
        Column(modifier = Modifier.weight(1f)) {
            homeSubs.forEach {
                Text(
                    text = it,
                    style = TextStyle(WhiteAlphaColor, fontSize = 12.sp),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                )
            }
        }
        Column(modifier = Modifier.weight(1f)) {
            awaySubs.forEach {
                Text(
                    text = it,
                    style = TextStyle(WhiteAlphaColor, fontSize = 12.sp),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Formations(homeFormation: String, awayFormation: String) {
    Text(
        text = stringResource(id = R.string.formation).uppercase(),
        style = TextStyle(
            color = WhiteAlphaColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(0.4.dp, WhiteAlphaColor, RoundedCornerShape(8.dp))
    ) {
        Text(
            text = homeFormation,
            style = TextStyle(WhiteAlphaColor, fontSize = 12.sp),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                .weight(1f)
        )
        Text(
            text = awayFormation,
            style = TextStyle(WhiteAlphaColor, fontSize = 12.sp),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                .weight(1f)
        )
    }
}

@Composable
fun StartingXI(homeXI: List<String>, awayXI: List<String>) {
    Text(
        text = stringResource(id = R.string.starting_xi).uppercase(),
        style = TextStyle(
            color = WhiteAlphaColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(0.4.dp, WhiteAlphaColor, RoundedCornerShape(8.dp))
    ) {
        Column(modifier = Modifier.weight(1f)) {
            homeXI.forEach {
                Text(
                    text = it,
                    style = TextStyle(WhiteAlphaColor, fontSize = 12.sp),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                )
            }
        }
        Column(modifier = Modifier.weight(1f)) {
            awayXI.forEach {
                Text(
                    text = it,
                    style = TextStyle(WhiteAlphaColor, fontSize = 12.sp),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Coaches(homeCoach: String, awayCoach: String) {
    Text(
        text = stringResource(id = R.string.coaches).uppercase(),
        style = TextStyle(
            color = WhiteAlphaColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(0.4.dp, WhiteAlphaColor, RoundedCornerShape(8.dp))
    ) {
        Text(
            text = homeCoach,
            style = TextStyle(WhiteAlphaColor, fontSize = 12.sp),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                .weight(1f)
        )
        Text(
            text = awayCoach,
            style = TextStyle(WhiteAlphaColor, fontSize = 12.sp),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                .weight(1f)
        )
    }
}

@Preview
@Composable
fun LineupsPrev() {
    LineupsScreen()
}
