package com.example.footyscores.presentation.fixture_details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footyscores.common.Resource
import com.example.footyscores.domain.model.fixturebyid.FixtureByIdResponse
import com.example.footyscores.domain.use_case.get_fixture_details.GetFixtureDetailsUseCase
import com.google.accompanist.pager.ExperimentalPagerApi
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

    fun getFixtureById(id: Int) {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            val result = getFixtureDetailsUseCase(id).fixtureByIdResponse
            _state.value = _state.value.copy(loading = false)
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        fixtureDetails = result.data ?: FixtureByIdResponse()
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(error = result.message)
                }
            }
        }
    }
}