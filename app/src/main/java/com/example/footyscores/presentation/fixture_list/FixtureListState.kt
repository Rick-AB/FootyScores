package com.example.footyscores.presentation.fixture_list

import com.example.footyscores.domain.model.fixturebydate.Response

data class FixtureListState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val fixtures: List<Response> = emptyList(),
    val error: String? = null
)