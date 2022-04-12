package com.example.footyscores.presentation.fixture_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footyscores.R
import com.example.footyscores.presentation.ui.theme.LatoFont
import com.example.footyscores.presentation.ui.theme.LightGreyColor
import com.example.footyscores.presentation.ui.theme.WhiteAlphaColor

@Composable
fun MatchPendingTile(stringResource: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(LightGreyColor, shape = RoundedCornerShape(8.dp))
            .padding(all = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_outline_info_24),
            contentDescription = "",
            tint = WhiteAlphaColor
        )
        Text(
            text = stringResource(id = stringResource), style = TextStyle(
                color = WhiteAlphaColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = LatoFont.fontFamily
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
