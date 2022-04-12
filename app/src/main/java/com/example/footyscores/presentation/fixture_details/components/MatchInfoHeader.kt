package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.footyscores.common.Constants
import com.example.footyscores.common.Constants.FULL_TIME
import com.example.footyscores.common.Constants.HALF_TIME
import com.example.footyscores.common.Constants.NOT_START
import com.example.footyscores.common.getFormattedDateFromDateString
import com.example.footyscores.common.getTimeFromDateString
import com.example.footyscores.presentation.fixture_details.FixtureDetailsState
import com.example.footyscores.presentation.ui.theme.LatoFont
import com.example.footyscores.presentation.ui.theme.LightGreyColor
import com.example.footyscores.presentation.ui.theme.Orange
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun MatchInfoHeader(
    state: FixtureDetailsState,
    homeTeamName: String,
    homoTeamLogo: String,
    awayTeamName: String,
    awayTeamLogo: String,
    date: String,
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightGreyColor, shape = RoundedCornerShape(8.dp))
            .padding(vertical = 20.dp)
    ) {
        val (homeTeamImage, homeTeamText, startTimeText, dateText, awayTeamText, awayTeamImage, onGoingIndicator) = createRefs()

        val matchStatusShort = state.fixtureDetails?.fixture?.status?.short
        val homeGoal = state.fixtureDetails?.goals?.home
        val awayGoal = state.fixtureDetails?.goals?.away
        val infoText = when (matchStatusShort) {
            NOT_START -> getTimeFromDateString(date)
            else -> "$homeGoal - $awayGoal"
        }

        val statusText = when (matchStatusShort) {
            NOT_START -> getFormattedDateFromDateString(date)
            FULL_TIME -> "Full Time"
            HALF_TIME -> "Half Time"
            else -> state.fixtureDetails?.fixture?.status?.elapsed.toString() + "`"
        }

        val statusDisplayColor = when (matchStatusShort) {
            NOT_START -> Color.White
            FULL_TIME -> Color.White
            else -> Orange
        }

        val statusModifier = when (matchStatusShort) {
            NOT_START -> Modifier.alpha(0.7f)
            FULL_TIME -> Modifier.alpha(0.7f)
            else -> Modifier.alpha(1f)
        }

        val statusFontWeight = when (matchStatusShort) {
            NOT_START -> FontWeight.Normal
            FULL_TIME -> FontWeight.Normal
            HALF_TIME -> FontWeight.Bold
            else -> FontWeight.Bold
        }

        Text(
            text = if (state.loading) getTimeFromDateString(date) else infoText,
            style = TextStyle(Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold, fontFamily = LatoFont.fontFamily),
            modifier = Modifier.constrainAs(startTimeText) {
                top.linkTo(homeTeamImage.top)
                bottom.linkTo(homeTeamImage.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = if (state.loading) getFormattedDateFromDateString(date) else statusText,
            style = TextStyle(
                if (state.loading) Color.White else statusDisplayColor,
                fontSize = 10.sp,
                fontWeight = statusFontWeight,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = statusModifier
                .constrainAs(dateText) {
                    top.linkTo(homeTeamText.top)
                    start.linkTo(startTimeText.start)
                    end.linkTo(startTimeText.end)
                    bottom.linkTo(homeTeamText.bottom)
                }
        )

        val homeTeamCoilPainter = rememberCoilPainter(request = homoTeamLogo)
        Image(
            painter = homeTeamCoilPainter,
            contentDescription = "Home Team Logo",
            modifier = Modifier
                .size(32.dp)
                .constrainAs(homeTeamImage) {
                    linkTo(start = parent.start, end = startTimeText.start, bias = 0.45f)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = homeTeamName,
            style = TextStyle(
                Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.constrainAs(homeTeamText) {
                top.linkTo(homeTeamImage.bottom, margin = 8.dp)
                start.linkTo(homeTeamImage.start)
                end.linkTo(homeTeamImage.end)
                width = Dimension.value(100.dp)
            }
        )

        val awayTeamCoilPainter = rememberCoilPainter(request = awayTeamLogo)
        Image(
            painter = awayTeamCoilPainter,
            contentDescription = "Away Team Logo",
            modifier = Modifier
                .size(32.dp)
                .constrainAs(awayTeamImage) {
                    linkTo(start = startTimeText.end, end = parent.end, bias = 0.55f)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = awayTeamName,
            style = TextStyle(
                Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily,
            ),
            modifier = Modifier.constrainAs(awayTeamText) {
                top.linkTo(awayTeamImage.bottom, margin = 8.dp)
                start.linkTo(awayTeamImage.start)
                end.linkTo(awayTeamImage.end)
                width = Dimension.value(100.dp)
            }
        )

        val matchOngoing =
            matchStatusShort == Constants.LIVE || matchStatusShort == HALF_TIME || matchStatusShort == Constants.FIRST_HALF || matchStatusShort == Constants.SECOND_HALF || matchStatusShort == Constants.EXTRA_TIME
        if (matchOngoing) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
                .background(Orange)
                .constrainAs(onGoingIndicator) {
                    top.linkTo(homeTeamImage.top)
                    bottom.linkTo(homeTeamText.bottom)
                    start.linkTo(parent.start)
                    height = Dimension.fillToConstraints
                    width = Dimension.value(6.dp)
                })
        }
    }
}

@Preview
@Composable
fun DefaultPrev() {
//    MatchInfoHeader()
}