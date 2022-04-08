package com.example.footyscores.presentation.fixture_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footyscores.common.Constants.INTERESTED_LEAGUE_IDS
import com.example.footyscores.common.Resource
import com.example.footyscores.common.getDateRanges
import com.example.footyscores.common.getFormattedDateStringFormat
import com.example.footyscores.domain.model.fixturebydate.Response
import com.example.footyscores.domain.use_case.get_fixtures.GetFixturesByDateUseCase
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalPagerApi::class)
@HiltViewModel
class FixtureListViewModel @Inject constructor(
    private val getFixturesByDateUseCase: GetFixturesByDateUseCase
) : ViewModel() {

    private val _state = mutableStateOf(FixtureListState())
    val state: State<FixtureListState> = _state
    val dateRanges = getDateRanges()
    val pagerState = PagerState(currentPage = 2)
    private val currentDate =
        mutableStateOf(getFormattedDateStringFormat(dateRanges[pagerState.currentPage]))


    init {
        viewModelScope.launch {
            snapshotFlow { pagerState.currentPage }.distinctUntilChanged().collectLatest {
                currentDate.value = getFormattedDateStringFormat(dateRanges[it])
                getFixturesByDate(currentDate.value)
            }
        }
    }

    private fun getFixturesByDate(date: String) {
        getFixturesByDateUseCase(date).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val filteredResponse = filterFixturesByLeagueIds(result.data ?: emptyList())
                    _state.value = _state.value.copy(
                        fixtures = filteredResponse,
                        isRefreshing = false,
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value =
                        _state.value.copy(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false,
                            isRefreshing = false
                        )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun refreshData() {
        _state.value = _state.value.copy(isRefreshing = true)
        getFixturesByDate(currentDate.value)
    }

    private fun filterFixturesByLeagueIds(fixtures: List<Response>): List<Response> {
        if (fixtures.isEmpty()) {
            return fixtures
        }
        return fixtures.filter {
            val leagueId = it.league.id!!
            INTERESTED_LEAGUE_IDS.contains(leagueId)
        }
    }
}