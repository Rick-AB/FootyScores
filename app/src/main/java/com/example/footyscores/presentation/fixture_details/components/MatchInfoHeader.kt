package com.example.footyscores.presentation.fixture_details.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.footyscores.common.getFormattedDateFromDateString
import com.example.footyscores.common.getTimeFromDateString
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun MatchInfoHeader(
    homeTeamName: String,
    homoTeamLogo: String,
    awayTeamName: String,
    awayTeamLogo: String,
    date: String,
    time: String,
) {
    Log.d("TAG", "MatchInfoHeader: $homoTeamLogo")
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray.copy(alpha = 0.3f), shape = RoundedCornerShape(8.dp))
            .padding(vertical = 20.dp)
    ) {
        val (homeTeamImage, homeTeamText, startTimeText, dateText, awayTeamText, awayTeamImage) = createRefs()

        Text(
            text = getTimeFromDateString(date),
            style = TextStyle(Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.constrainAs(startTimeText) {
                top.linkTo(homeTeamImage.top)
                bottom.linkTo(homeTeamImage.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = getFormattedDateFromDateString(date),
            style = TextStyle(
                Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .alpha(0.7f)
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
                .size(48.dp)
                .constrainAs(homeTeamImage) {
                    linkTo(start = parent.start, end = startTimeText.start, bias = 0.35f)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = homeTeamName,
            style = TextStyle(
                Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
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
                .size(48.dp)
                .constrainAs(awayTeamImage) {
                    linkTo(start = startTimeText.end, end = parent.end, bias = 0.65f)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = awayTeamName,
            style = TextStyle(
                Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.constrainAs(awayTeamText) {
                top.linkTo(awayTeamImage.bottom, margin = 8.dp)
                start.linkTo(awayTeamImage.start)
                end.linkTo(awayTeamImage.end)
                width = Dimension.value(100.dp)
            }
        )

    }
}

@Preview
@Composable
fun DefaultPrev() {
//    MatchInfoHeader()
}