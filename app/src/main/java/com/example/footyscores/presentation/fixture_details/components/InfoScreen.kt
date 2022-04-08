package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footyscores.R
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun InfoScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp, start = 8.dp, end = 8.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 0.4.dp,
                        color = WhiteAlphaColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(all = 12.dp)
            ) {
                InfoItem(icon = R.drawable.ic_outline_calendar_month_24, text = "01 Apr 2022")
                InfoItem(icon = R.drawable.ic_whistle, text = "Mike Dean (England)")
                InfoItem(icon = R.drawable.ic_stadium, text = "Old Trafford")
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.table).uppercase(),
                style = TextStyle(
                    color = WhiteAlphaColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Table()
        }
    }
}

@Composable
fun Table() {
    Box(
        modifier = Modifier
            .border(
                0.4.dp,
                color = WhiteAlphaColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp)
    ) {
        Column {
            TableHeader()
            Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
            TableKeys()
            Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
            TableValue()
            Divider(color = WhiteAlphaColor, thickness = 0.4.dp)
            TableValue()
        }
    }
}

@Composable
fun TableValue() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
    ) {
        Text(
            text = "4",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.width(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Row(modifier = Modifier.weight(3.5f), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberCoilPainter(request = ""),
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Huddersfield Town",
                style = TextStyle(
                    color = WhiteAlphaColor,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }

        Text(
            text = "39",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "8",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "63",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
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
            .padding(vertical = 14.dp)
    ) {
        Text(
            text = "#",
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.width(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(id = R.string.team).uppercase(),
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
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
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(id = R.string.goal_difference_abv).uppercase(),
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(id = R.string.points_abv).uppercase(),
            style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun TableHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
    ) {
        val coilPainter = rememberCoilPainter(request = "")
        Image(
            painter = coilPainter,
            contentDescription = "League flag",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "ChampionShip",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(text = "England", style = TextStyle(color = WhiteAlphaColor, fontSize = 10.sp))
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
            style = TextStyle(color = WhiteAlphaColor, fontSize = 10.sp)
        )
    }
}

@Preview
@Composable
fun InfoPreview() {
    InfoScreen()
}