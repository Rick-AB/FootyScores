package com.example.footyscores.presentation.fixture_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.footyscores.R
import com.example.footyscores.common.Constants.EXTRA_TIME
import com.example.footyscores.common.Constants.FIRST_HALF
import com.example.footyscores.common.Constants.FULL_TIME
import com.example.footyscores.common.Constants.HALF_TIME
import com.example.footyscores.common.Constants.LIVE
import com.example.footyscores.common.Constants.NOT_START
import com.example.footyscores.common.Constants.SECOND_HALF
import com.example.footyscores.common.getTimeFromDateString
import com.example.footyscores.domain.model.fixturebydate.Response
import com.example.footyscores.presentation.ui.theme.LatoFont
import com.example.footyscores.presentation.ui.theme.LightGreyColor
import com.example.footyscores.presentation.ui.theme.Orange
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun FixtureListItem(matchInfo: Response, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp, end = 8.dp, start = 8.dp)
            .background(LightGreyColor, RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(end = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val matchStatusShort = matchInfo.fixture.status.short
        val matchStatusDisplayText = when (matchStatusShort) {
            NOT_START -> matchInfo.fixture.date.let { getTimeFromDateString(it) }
            FULL_TIME -> "FT"
            HALF_TIME -> "HT"
            else -> matchInfo.fixture.status.elapsed.toString() + "`"
        }
        val matchStatusDisplayColor = when (matchStatusShort) {
            NOT_START -> Color.White
            FULL_TIME -> Color.White
            else -> Orange
        }
        val matchStatusFontWeight = when (matchStatusShort) {
            NOT_START -> FontWeight.Normal
            FULL_TIME -> FontWeight.Normal
            HALF_TIME -> FontWeight.Bold
            else -> FontWeight.Bold
        }
        val modifierAlpha = when (matchStatusShort) {
            NOT_START -> Modifier.alpha(0.7f)
            FULL_TIME -> Modifier.alpha(0.7f)
            else -> Modifier.alpha(1f)
        }

        val matchOngoing =
            matchStatusShort == LIVE || matchStatusShort == HALF_TIME || matchStatusShort == FIRST_HALF || matchStatusShort == SECOND_HALF || matchStatusShort == EXTRA_TIME
        if (matchOngoing) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
                    .background(Orange)
            )
            Spacer(modifier = Modifier.width(15.dp))
        } else {
            Spacer(modifier = Modifier.width(20.dp))
        }

        Text(
            text = matchStatusDisplayText,
            color = matchStatusDisplayColor,
            fontSize = 11.sp,
            fontWeight = matchStatusFontWeight,
            modifier = modifierAlpha.width(30.dp),
            textAlign = TextAlign.Center,
            fontFamily = LatoFont.fontFamily
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val coilPainter = rememberCoilPainter(
                    request = matchInfo.teams.home.logo,
                )
                when (coilPainter.loadState) {
                    is ImageLoadState.Success -> Image(
                        painter = coilPainter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                    )
                    else -> Icon(
                        painter = rememberImagePainter(data = R.drawable.ic_default_sport_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp),
                        tint = WhiteAlphaColor
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = matchInfo.teams.home.name!!,
                    style = MaterialTheme.typography.body1.copy(fontSize = 12.sp, fontFamily = LatoFont.fontFamily),
                    modifier = Modifier.weight(1f)
                )

                if (matchStatusShort != NOT_START) {
                    Text(
                        text = matchInfo.goals.home.toString(),
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LatoFont.fontFamily
                        )
                    )
                }

            }

            Spacer(modifier = Modifier.height(5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val coilPainter = rememberCoilPainter(
                    request = matchInfo.teams.away.logo,
                )
                when (coilPainter.loadState) {
                    is ImageLoadState.Success -> Image(
                        painter = coilPainter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                    )
                    else -> Icon(
                        painter = rememberImagePainter(data = R.drawable.ic_default_sport_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp),
                        tint = WhiteAlphaColor
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = matchInfo.teams.away.name!!,
                    style = MaterialTheme.typography.body1.copy(fontSize = 12.sp, fontFamily = LatoFont.fontFamily),
                    modifier = Modifier.weight(1f)
                )

                if (matchStatusShort != NOT_START) {
                    Text(
                        text = matchInfo.goals.away.toString(),
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LatoFont.fontFamily
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(12.dp))
        Icon(imageVector = Icons.Default.StarBorder, contentDescription = "Favorite")
    }
}

