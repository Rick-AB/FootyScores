package com.example.footyscores.presentation.fixture_details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footyscores.common.Resource
import com.example.footyscores.domain.use_case.GetFixtureDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureDetailsViewModel
@Inject
constructor(
    private val getFixtureDetailsUseCase: GetFixtureDetailsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(FixtureDetailsState())
    val state = _state

    init {
        _state.value = _state.value.copy(loading = true)
    }

    fun getFixtureById(id: Int) {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            val result = getFixtureDetailsUseCase(id)
            val fixtureDetails = result.fixtureByIdResponse
            val leagueStandings = result.leagueStandingsByLeagueIdResponse
            _state.value = _state.value.copy(loading = false, isRefreshing = false)
            when (fixtureDetails) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        fixtureDetails = fixtureDetails.data
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(error = fixtureDetails.message)
                }
            }

            when (leagueStandings) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        leagueStandings = leagueStandings.data
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(error = leagueStandings.message)
                }
            }

        }
    }

    fun refresh() {
        _state.value = _state.value.copy(isRefreshing = true)
        getFixtureById(_state.value.fixtureDetails?.fixture?.id!!)
    }
}