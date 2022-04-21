package com.example.footyscores.presentation.favoritefixtures

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footyscores.common.Resource
import com.example.footyscores.domain.use_case.GetFavoriteFixtures
import com.example.footyscores.domain.use_case.UpdateFixtureFavoriteStatus
import com.example.footyscores.presentation.fixture_list.FixtureListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteFixturesViewModel @Inject constructor(
    private val updateFixtureFavoriteStatus: UpdateFixtureFavoriteStatus,
    getFavoriteFixtures: GetFavoriteFixtures
) : ViewModel() {

    private val _state = mutableStateOf(FavoriteFixturesState())
    val state = _state
    private var job = Job()
        get() {
            if (field.isCancelled) field = Job()
            return field
        }

    init {
        getFavoriteFixtures().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(data = result.data ?: emptyList())
                }
                else -> {
                    _state.value = _state.value.copy(error = "Couldn't load fixture")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: FixtureListEvent) {
        when (event) {
            is FixtureListEvent.OnFavoriteClick -> {
                job.cancel()
                viewModelScope.launch {
                    updateFixtureFavoriteStatus(event.fixtureId, event.favoriteStatus)
                }
            }
            else -> {
                _state.value = _state.value.copy(error = "Event not registered")
            }
        }
    }
}