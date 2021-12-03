package com.example.footyscores.presentation.fixture_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footyscores.common.Resource
import com.example.footyscores.domain.use_case.get_fixtures.GetFixturesByDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FixtureListViewModel @Inject constructor(
    private val getFixturesByDateUseCase: GetFixturesByDateUseCase
) : ViewModel() {

    private val _state = mutableStateOf(FixtureListState())
    val state: State<FixtureListState> = _state

    fun getFixturesByDate(date: String) {
        getFixturesByDateUseCase(date).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = FixtureListState(fixtures = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = FixtureListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = FixtureListState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}