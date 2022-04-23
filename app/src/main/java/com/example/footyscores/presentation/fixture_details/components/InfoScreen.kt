package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import com.example.footyscores.R
import com.example.footyscores.common.Constants.leaguesOfInterestList
import com.example.footyscores.common.getFormattedDateFromDateString
import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsStanding
import com.example.footyscores.presentation.fixture_details.FixtureDetailsState
import com.example.footyscores.presentation.ui.theme.LatoFont
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode
import java.util.*

@Composable
fun InfoScreen(
    state: FixtureDetailsState,
) {
    val expandedTable = remember {
        mutableStateOf(false)
    }
    val homeTeamId = state.fixtureDetails?.teams?.home?.id
    val awayTeamId = state.fixtureDetails?.teams?.away?.id
    val leagueStandings = state.leagueStandings?.league?.standings?.get(0)
    val currentTeamsStandings = leagueStandings?.filter {
        it.team.id == homeTeamId || it.team.id == awayTeamId
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 8.dp, end = 8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        FlowRow(
            mainAxisAlignment = MainAxisAlignment.Center,
            mainAxisSize = SizeMode.Expand,
            crossAxisSpacing = 12.dp,
            mainAxisSpacing = 12.dp,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 0.4.dp,
                    color = WhiteAlphaColor,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(12.dp)
        ) {
            val fixtureDate =
                state.fixtureDetails?.fixture?.date?.let {
                    getFormattedDateFromDateString(
                        it,
                        false
                    )
                }
            val referee = state.fixtureDetails?.fixture?.referee
            val stadium = state.fixtureDetails?.fixture?.venue?.name
            fixtureDate?.let {
                InfoItem(icon = R.drawable.ic_outline_calendar_month_24, text = fixtureDate)
            }
            referee?.let {
                InfoItem(icon = R.drawable.ic_whistle, text = it)
            }
            stadium?.let {
                InfoItem(icon = R.drawable.ic_stadium, text = it)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        val isLeague = leaguesOfInterestList.contains(state.fixtureDetails?.league?.id)
        if (isLeague) {
            val leagueCountry = state.fixtureDetails?.league?.country
            val leagueName = state.fixtureDetails?.league?.name
            val leagueFlag = state.fixtureDetails?.league?.flag
            Text(
                text = stringResource(id = R.string.table).uppercase(),
                style = TextStyle(
                    color = WhiteAlphaColor,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = LatoFont.fontFamily
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Table(
                leagueName!!, leagueFlag,
                leagueCountry!!.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                if (expandedTable.value) leagueStandings!! else currentTeamsStandings!!,
                expandedTable.value
            ) {
                expandedTable.value = !expandedTable.value
            }
        } else {
            Box(
                modifier = Modifier
                    .border(
                        0.4.dp,
                        color = WhiteAlphaColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding()
            ) {
                val cupRound = state.fixtureDetails?.league?.round
                val cupName = state.fixtureDetails?.league?.name
                val cupLogo = state.fixtureDetails?.league?.logo
                TableHeader(
                    leagueName = cupName!!,
                    leagueFlag = cupLogo!!,
                    leagueCountry = cupRound!!
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun Table(
    leagueName: String,
    leagueFlag: String?,
    leagueCountry: String,
    standings: List<LeagueStandingsStanding>,
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .border(
                0.4.dp,
                color = WhiteAlphaColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding()
    ) {
//        LazyColumn {
//            item {
//                TableHeader(leagueName, leagueFlag, leagueCountry)
//                Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
//            }
//            item {
//                TableKeys()
//                Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
//            }
//            items(standings, key = { it.team.id }) {
//                TableValue(Modifier.animateItemPlacement(), it)
//                Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
//            }
//            item {
//                Row(
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .clickable { onClick() }
//                        .fillMaxWidth()
//                        .padding(vertical = 8.dp)
//                ) {
//                    Text(
//                        text = if (isExpanded) "See Less" else "See All",
//                        style = TextStyle(
//                            color = WhiteAlphaColor,
//                            fontSize = 10.sp,
//                            textAlign = TextAlign.Center
//                        )
//                    )
//                }
//            }
//        }
        Column(modifier = Modifier.animateContentSize()) {
            TableHeader(leagueName, leagueFlag, leagueCountry)
            Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
            TableKeys()
            Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
            standings.forEach {
                TableValue(modifier = Modifier, it)
//                Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
            }
            Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { onClick() }
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = if (isExpanded) "See Less" else "See All",
                    style = TextStyle(
                        color = WhiteAlphaColor,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = LatoFont.fontFamily
                    )
                )
            }
        }
    }
}

@Composable
fun TableValue(modifier: Modifier, leagueStandingsStanding: LeagueStandingsStanding) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp, start = 12.dp, end = 8.dp)
    ) {
        Text(
            text = "${leagueStandingsStanding.rank}",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.width(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Row(modifier = Modifier.weight(3.5f), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberCoilPainter(request = leagueStandingsStanding.team.logo),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = leagueStandingsStanding.team.name,
                style = TextStyle(
                    color = WhiteAlphaColor,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = LatoFont.fontFamily
                )
            )
        }

        Text(
            text = "${leagueStandingsStanding.all.played}",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "${leagueStandingsStanding.goalsDiff}",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "${leagueStandingsStanding.points}",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun TableKeys() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 8.dp)
    ) {
        Text(
            text = "#",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.width(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(id = R.string.team).uppercase(),
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.weight(3.5f)
        )
        Text(
            text = stringResource(id = R.string.played_abv).uppercase(),
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(id = R.string.goal_difference_abv).uppercase(),
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(id = R.string.points_abv).uppercase(),
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun TableHeader(leagueName: String, leagueFlag: String?, leagueCountry: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp, bottom = 14.dp, start = 12.dp, end = 8.dp)
    ) {
        val isSvg = !leagueFlag?.endsWith("svg")!!
        val modifier =
            if (!isSvg) Modifier.size(30.dp, 12.dp) else Modifier.size(48.dp)
        Image(
            painter = rememberImagePainter(data = leagueFlag, builder = {
                decoder(SvgDecoder(LocalContext.current))
            }),
            contentDescription = "League flag",
            modifier = modifier
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = leagueName,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = LatoFont.fontFamily
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = leagueCountry,
                style = TextStyle(
                    color = WhiteAlphaColor,
                    fontSize = 10.sp,
                    fontFamily = LatoFont.fontFamily
                )
            )
        }

    }
}

@Composable
fun InfoItem(icon: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = WhiteAlphaColor
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontFamily = LatoFont.fontFamily
            )
        )
    }
}

@Preview
@Composable
fun InfoPreview() {
//    InfoScreen(FixtureDetailsState())
}