package com.example.footyscores.presentation.fixture_list

import com.example.footyscores.data.remote.dto.ResponseDto

data class FixtureListState(
    val isLoading: Boolean = false,
    val fixtures: List<ResponseDto> = emptyList(),
    val error: String = ""
)