package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footyscores.R
import com.example.footyscores.domain.model.fixturebyid.FixtureByIdStartXI
import com.example.footyscores.domain.model.fixturebyid.FixtureByIdSubstitute
import com.example.footyscores.presentation.fixture_details.FixtureDetailsState
import com.example.footyscores.presentation.ui.theme.LatoFont
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor

@Composable
fun LineupsScreen(
    state: FixtureDetailsState,
    nestedScrollConnection: NestedScrollConnection
) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 8.dp, end = 8.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val lineupsAvailable = state.fixtureDetails?.lineups?.isNotEmpty()!!
        if (!lineupsAvailable) {
            MatchPendingTile(stringResource = R.string.match_pending_lineups)
        } else {
            val homeFormation = state.fixtureDetails.lineups[0].formation!!
            val awayFormation = state.fixtureDetails.lineups[1].formation!!
            val homeStartingXI = state.fixtureDetails.lineups[0].startXI
            val awayStartingXI = state.fixtureDetails.lineups[1].startXI
            val homeCoach = state.fixtureDetails.lineups[0].coach.name
            val awayCoach = state.fixtureDetails.lineups[1].coach.name
            val homeSubs = state.fixtureDetails.lineups[0].substitutes
            val awaySubs = state.fixtureDetails.lineups[1].substitutes
            Formations(homeFormation, awayFormation)
            Spacer(modifier = Modifier.height(16.dp))
            StartingXI(homeXI = homeStartingXI, awayXI = awayStartingXI)
            Spacer(modifier = Modifier.height(16.dp))
            Substitutes(homeSubs = homeSubs, awaySubs = awaySubs)
            Spacer(modifier = Modifier.height(16.dp))
            Coaches(homeCoach = homeCoach, awayCoach = awayCoach)
            Spacer(modifier = Modifier.height(50.dp))
        }

    }
}

@Composable
fun Substitutes(homeSubs: List<FixtureByIdSubstitute>, awaySubs: List<FixtureByIdSubstitute>) {
    Text(
        text = stringResource(id = R.string.substitute_players).uppercase(),
        style = TextStyle(
            color = WhiteAlphaColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = LatoFont.fontFamily
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
                PlayerItem(playerNumber = "${it.player.number}", playerName = it.player.name!!)
            }
        }
        Column(modifier = Modifier.weight(1f)) {
            awaySubs.forEach {
                PlayerItem(playerNumber = "${it.player.number}", playerName = it.player.name!!)
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
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = LatoFont.fontFamily
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
            style = TextStyle(WhiteAlphaColor, fontSize = 12.sp, fontFamily = LatoFont.fontFamily),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                .weight(1f)
        )
        Text(
            text = awayFormation,
            style = TextStyle(WhiteAlphaColor, fontSize = 12.sp, fontFamily = LatoFont.fontFamily),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                .weight(1f)
        )
    }
}

@Composable
fun StartingXI(homeXI: List<FixtureByIdStartXI>, awayXI: List<FixtureByIdStartXI>) {
    Text(
        text = stringResource(id = R.string.starting_xi).uppercase(),
        style = TextStyle(
            color = WhiteAlphaColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = LatoFont.fontFamily
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
                PlayerItem(playerNumber = "${it.player.number}", playerName = it.player.name!!)
            }
        }
        Column(modifier = Modifier.weight(1f)) {
            awayXI.forEach {
                PlayerItem(playerNumber = "${it.player.number}", playerName = it.player.name!!)
            }
        }
    }
}

@Composable
fun PlayerItem(playerNumber: String, playerName: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(20.dp)
                .border(1.dp, color = Color.White, CircleShape)
        ) {
            Text(
                text = playerNumber,
                style = TextStyle(
                    WhiteAlphaColor,
                    fontSize = 10.sp,
                    fontFamily = LatoFont.fontFamily
                ),
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = playerName,
            style = TextStyle(WhiteAlphaColor, fontSize = 10.sp, fontFamily = LatoFont.fontFamily),
        )
    }
}

@Composable
fun Coaches(homeCoach: String, awayCoach: String) {
    Text(
        text = stringResource(id = R.string.coaches).uppercase(),
        style = TextStyle(
            color = WhiteAlphaColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = LatoFont.fontFamily
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
            style = TextStyle(WhiteAlphaColor, fontSize = 12.sp, fontFamily = LatoFont.fontFamily),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                .weight(1f)
        )
        Text(
            text = awayCoach,
            style = TextStyle(WhiteAlphaColor, fontSize = 12.sp, fontFamily = LatoFont.fontFamily),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                .weight(1f)
        )
    }
}

@Preview
@Composable
fun LineupsPrev() {
//    LineupsScreen(FixtureDetailsState(), lazyListState, nestedScrollConnection)
}
