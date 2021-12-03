package com.example.footyscores.presentation.fixture_list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.footyscores.data.remote.dto.ResponseDto
import com.example.footyscores.presentation.fixture_list.components.FixtureListItem
import com.example.footyscores.presentation.fixture_list.components.SectionHeader
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun FixtureListScreen(
    date: Long,
    viewModel: FixtureListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val fixtures = state.fixtures
    LaunchedEffect(key1 = date) {
        viewModel.getFixturesByDate(getFormattedDateStringFormat(date))
    }

    SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = state.isLoading), onRefresh = {
        viewModel.getFixturesByDate(
            getFormattedDateStringFormat(date)
        )
    }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            val grouped = fixtures.groupBy { it.league.id }
            grouped.forEach { (_, fixtures) ->
                item { SectionHeader(fixtures[0].league) }
                items(fixtures) {
                    FixtureListItem(it)
                }
            }
        }
    }

}

private fun getFormattedDateStringFormat(date: Long): String {
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return dateFormatter.format(Date(date))
}