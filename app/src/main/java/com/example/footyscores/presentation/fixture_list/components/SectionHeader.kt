package com.example.footyscores.presentation.fixture_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.footyscores.data.remote.dto.LeagueDto
import com.example.footyscores.data.remote.dto.ResponseDto

@ExperimentalCoilApi
@Composable
fun SectionHeader(leagueDto: LeagueDto = LeagueDto()) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(leagueDto.logo),
            contentDescription = null,
            modifier = Modifier.size(40.dp, 24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = leagueDto.name,
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = leagueDto.round,
                style = MaterialTheme.typography.body2.copy(fontSize = 10.sp),
                modifier = Modifier.alpha(0.7f)
            )
        }
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
    }
}