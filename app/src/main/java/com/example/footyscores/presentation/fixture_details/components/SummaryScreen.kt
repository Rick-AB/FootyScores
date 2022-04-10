package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.footyscores.R
import com.example.footyscores.common.Constants.CARD_EVENT
import com.example.footyscores.common.Constants.GOAL_EVENT
import com.example.footyscores.common.Constants.INTERESTED_EVENTS
import com.example.footyscores.common.Constants.YELLOW_CARD_EVENT
import com.example.footyscores.domain.model.fixturebyid.FixtureByIdEvent
import com.example.footyscores.presentation.fixture_details.FixtureDetailsState
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor
import com.example.footyscores.presentation.ui.theme.Yellow
import java.util.*

@Composable
fun SummaryScreen(
    state: FixtureDetailsState,
    lazyListState: LazyListState,
    nestedScrollConnection: NestedScrollConnection
) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .nestedScroll(nestedScrollConnection)
    ) {
        val homeGoals = remember {
            mutableListOf(0)
        }
        val awayGoals = remember {
            mutableListOf(0)
        }
        val events = state.fixtureDetails?.events!!
        val homeTeamId = state.fixtureDetails.teams.home.id
        val awayTeamId = state.fixtureDetails.teams.away.id
        if (events.isEmpty()) {
            MatchPendingTile(R.string.match_pending_summary_text)
        } else {
            events.filter { INTERESTED_EVENTS.contains(it.type) }.forEachIndexed { index, it ->
                if (it.type?.lowercase() == GOAL_EVENT && it.team.id == homeTeamId) {
                    val goalCount = homeGoals[homeGoals.lastIndex].plus(1)
                    homeGoals.add(goalCount)
                } else {
                    val goalCount = homeGoals[homeGoals.lastIndex]
                    homeGoals.add(goalCount)
                }

                if (it.type?.lowercase() == GOAL_EVENT && it.team.id == awayTeamId) {
                    val goalCount = awayGoals[awayGoals.lastIndex].plus(1)
                    awayGoals.add(goalCount)
                } else {
                    val goalCount = awayGoals[awayGoals.lastIndex]
                    awayGoals.add(goalCount)
                }
                MatchEventItem(
                    homeTeamId,
                    awayTeamId,
                    homeGoals[index + 1],
                    awayGoals[index + 1],
                    it
                )
                Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Composable
fun MatchEventItem(
    homeTeamId: Int,
    awayTeamId: Int,
    homeGoal: Int,
    awayGoal: Int,
    event: FixtureByIdEvent
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp)
    ) {
        val (eventTimeText, homePlayerColumn, homeIconView, goalsText, awayPlayerColumn, awayIconView, guideline) = createRefs()

        Text(
            text = "${event.time.elapsed}`",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.constrainAs(eventTimeText) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.value(30.dp)
            }
        )

        if (event.type?.lowercase() == GOAL_EVENT) {
            Text(text = "$homeGoal - $awayGoal",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                ), modifier = Modifier.constrainAs(goalsText) {
                    start.linkTo(eventTimeText.end)
                    end.linkTo(parent.end)
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    width = Dimension.value(30.dp)
                })
        } else {
            Box(modifier = Modifier
                .constrainAs(guideline) {
                    start.linkTo(eventTimeText.end)
                    end.linkTo(parent.end)
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    width = Dimension.value(30.dp)
                })
        }

        if (homeTeamId == event.team.id) {
            when (event.type?.lowercase()) {
                CARD_EVENT -> CardComposable(Modifier.constrainAs(homeIconView) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    end.linkTo(guideline.start, margin = 12.dp)
                }, event.detail)
                GOAL_EVENT -> GoalComposeable(Modifier.constrainAs(homeIconView) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    end.linkTo(goalsText.start, margin = 12.dp)
                }, event.detail)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.constrainAs(homePlayerColumn) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    linkTo(
                        start = eventTimeText.end,
                        end = homeIconView.start,
                        bias = 0.85f
                    )
                }) {
                Text(
                    text = event.player.name!!,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 11.sp,
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold
                    ),
                )
                event.assist.name?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = WhiteAlphaColor,
                            fontSize = 10.sp,
                            textAlign = TextAlign.End,
                            fontWeight = FontWeight.Normal
                        ),
                    )
                }
            }
        } else {
            when (event.type?.lowercase()) {
                CARD_EVENT -> CardComposable(Modifier.constrainAs(awayIconView) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    start.linkTo(guideline.end, margin = 12.dp)
                }, event.detail)
                GOAL_EVENT -> GoalComposeable(Modifier.constrainAs(awayIconView) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    start.linkTo(goalsText.end, margin = 12.dp)
                }, event.detail)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.constrainAs(awayPlayerColumn) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    linkTo(
                        start = awayIconView.end,
                        end = parent.end,
                        bias = 0.15f
                    )
                }) {
                Text(
                    text = event.player.name!!,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 11.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    ),
                )
                event.assist.name?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = WhiteAlphaColor,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Normal
                        ),
                    )
                }
            }
        }
    }
}

@Composable
fun GoalComposeable(
    modifier: Modifier,
    detail: String?
) {
    Box(
        modifier = modifier
            .size(14.dp)
            .clip(CircleShape)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_football_filled),
            contentDescription = "",
            modifier
                .size(14.dp)
                .background(Color.White),
            tint = Color.Black
        )
    }
}

@Composable
fun CardComposable(
    modifier: Modifier,
    detail: String?
) {
    Box(
        modifier = modifier
            .size(height = 16.dp, width = 10.dp)
            .background(
                color = if (detail?.lowercase(Locale.getDefault()) == YELLOW_CARD_EVENT) Yellow else Color.Red,
                shape = RoundedCornerShape(2.dp)
            )
    )
}

@Preview
@Composable
fun SummaryPrev() {
//    SummaryScreen(FixtureDetailsState(), lazyListState, nestedScrollConnection)
}