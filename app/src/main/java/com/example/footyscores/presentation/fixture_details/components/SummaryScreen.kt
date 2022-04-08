package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.footyscores.R
import com.example.footyscores.domain.model.fixturebyid.FixtureByIdEvent
import com.example.footyscores.domain.model.fixturebyid.FixtureByIdTeam
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor
import java.util.*

@Composable
fun SummaryScreen(
    events: List<FixtureByIdEvent> = listOf(
        FixtureByIdEvent(
            team = FixtureByIdTeam(id = 0),
            type = "Card"
        )
    )
) {
    Column(modifier = Modifier.padding(top = 20.dp, start = 8.dp, end = 8.dp)) {
        val eventsList = ArrayList<FixtureByIdEvent>()
        for (i in 1..4) {
            eventsList.add(
                FixtureByIdEvent(
                    team = FixtureByIdTeam(id = 1),
                    type = "Goal"
                )
            )
        }
        if (eventsList.isEmpty()) {
            MatchPendingTile(R.string.match_pending_summary_text)
        } else {
            eventsList.forEach {
                MatchEventItem(0, it)
                Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
            }
        }
    }
}

@Composable
fun MatchEventItem(homeTeamId: Int, event: FixtureByIdEvent) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp)
    ) {
        val (eventTimeText, homePlayerColumn, homeIconView, goalsText, awayPlayerColumn, awayIconView) = createRefs()
        val guideline = createGuidelineFromStart(0.5f)
        Text(
            text = "7`",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.constrainAs(eventTimeText) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )

        if (event.type == "Goal") {
            Text(text = "1 - 1", style = TextStyle(
                color = Color.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            ), modifier = Modifier.constrainAs(goalsText) {
                start.linkTo(eventTimeText.end)
                end.linkTo(parent.end)
                top.linkTo(eventTimeText.top)
                bottom.linkTo(eventTimeText.bottom)
            })
        }

        if (homeTeamId == event.team.id) {
            when (event.type) {
                "Card" -> CardComposable(Modifier.constrainAs(homeIconView) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    end.linkTo(
                        if (event.type == "Goal") goalsText.start else guideline,
                        margin = 12.dp
                    )
                }, event.detail)
                "Goal" -> GoalComposeable(Modifier.constrainAs(homeIconView) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    end.linkTo(
                        if (event.type == "Goal") goalsText.start else guideline,
                        margin = 12.dp
                    )
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
                    text = "Sanchez",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold
                    ),
                )
                event.assist.name?.let {
                    Text(
                        text = "Son",
                        style = TextStyle(
                            color = WhiteAlphaColor,
                            fontSize = 12.sp,
                            textAlign = TextAlign.End,
                            fontWeight = FontWeight.Normal
                        ),
                    )
                }
            }
        } else {
            when (event.type) {
                "Card" -> CardComposable(Modifier.constrainAs(awayIconView) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    start.linkTo(
                        if (event.type == "Goal") goalsText.end else guideline,
                        margin = 12.dp
                    )
                }, event.detail)
                "Goal" -> GoalComposeable(Modifier.constrainAs(awayIconView) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    start.linkTo(
                        if (event.type == "Goal") goalsText.end else guideline,
                        margin = 12.dp
                    )
                }, event.detail)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.constrainAs(homePlayerColumn) {
                    top.linkTo(eventTimeText.top)
                    bottom.linkTo(eventTimeText.bottom)
                    linkTo(
                        start = awayIconView.end,
                        end = parent.end,
                        bias = 0.15f
                    )
                }) {
                Text(
                    text = "Sanchez",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    ),
                )
                event.assist.name?.let {
                    Text(
                        text = "Son",
                        style = TextStyle(
                            color = WhiteAlphaColor,
                            fontSize = 12.sp,
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
    cardDetail: String?
) {
    Box(modifier = modifier) {
        Icon(
            painter = painterResource(id = R.drawable.ic_football_filled),
            contentDescription = "",
            modifier
                .size(16.dp)
                .background(Color.White, shape = CircleShape),
        )
    }
}

@Composable
fun CardComposable(
    modifier: Modifier,
    cardDetail: String?
) {
    Box(
        modifier = modifier
            .size(height = 18.dp, width = 12.dp)
            .background(
                color = if (cardDetail?.lowercase(Locale.getDefault()) == "yellow card") Color.Yellow else Color.Red,
                shape = RoundedCornerShape(2.dp)
            )
    )
}

@Preview
@Composable
fun SummaryPrev() {
    SummaryScreen(listOf(FixtureByIdEvent()))
}