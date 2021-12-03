package com.example.footyscores.presentation.fixture_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.footyscores.data.remote.dto.ResponseDto
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalCoilApi
@Composable
fun FixtureListItem(fixture: ResponseDto = ResponseDto()) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.DarkGray.copy(0.3f), RoundedCornerShape(10.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (fixture.fixture.status.short == "NS")
                getTimeFromTimeStamp(fixture.fixture.timestamp.toLong())
            else fixture.fixture.status.elapsed.toString(),
            color = Color.White,
            fontSize = 11.sp,
            modifier = Modifier.alpha(0.7f)
        )

        Spacer(modifier = Modifier.width(12.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberImagePainter(fixture.teams.home.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = fixture.teams.home.name,
                    style = MaterialTheme.typography.body1.copy(fontSize = 12.sp),
                    modifier = Modifier.weight(1f)
                )

                if (fixture.fixture.status.short != "NS") {
                    Text(
                        text = fixture.goals.home.toString(),
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

            }

            Spacer(modifier = Modifier.height(5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberImagePainter(fixture.teams.away.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(24.dp)
                )
                Text(
                    text = fixture.teams.away.name,
                    style = MaterialTheme.typography.body1.copy(fontSize = 12.sp),
                    modifier = Modifier.weight(1f)
                )

                if (fixture.fixture.status.short != "NS") {
                    Text(
                        text = fixture.goals.away.toString(),
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(12.dp))
        Icon(imageVector = Icons.Default.StarBorder, contentDescription = "Favorite")
    }
}

fun getTimeFromTimeStamp(timestamp: Long): String {
    val timeFormatter = SimpleDateFormat("hh:mm", Locale.getDefault())
    return timeFormatter.format(Date(timestamp))
}

@ExperimentalCoilApi
@Composable
fun ListHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(painter = rememberImagePainter(""), contentDescription = null)
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
            Text(text = "", style = TextStyle(fontSize = 12.sp), modifier = Modifier.alpha(0.7f))

        }
    }
}