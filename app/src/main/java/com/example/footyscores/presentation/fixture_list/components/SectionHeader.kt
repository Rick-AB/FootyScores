package com.example.footyscores.presentation.fixture_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import com.example.footyscores.domain.model.fixturebydate.League
import com.example.footyscores.presentation.ui.theme.LatoFont
import java.util.*

@Composable
fun SectionHeader(league: League) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 12.dp, bottom = 12.dp, end = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val url = league.flag ?: league.logo
        val isSvg = url?.endsWith("svg")!!
        val modifier =
            if (isSvg) Modifier.size(30.dp, 12.dp) else Modifier.size(48.dp)
        Image(
            painter = if (!isSvg) rememberImagePainter(data = url) else rememberImagePainter(
                data = url,
                builder = {
                    decoder(SvgDecoder(LocalContext.current))
                }),
            contentDescription = "SVG Image",
            modifier = modifier.clip(RoundedCornerShape(4.dp)),
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            league.name?.let {
                Text(
                    text = it,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = LatoFont.fontFamily
                    )
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = if (league.country?.lowercase(Locale.getDefault()) == "world") league.round!! else league.country!!,
                style = MaterialTheme.typography.body2.copy(
                    fontSize = 10.sp,
                    fontFamily = LatoFont.fontFamily
                ),
                modifier = Modifier.alpha(0.7f)
            )
        }
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
    }
}
