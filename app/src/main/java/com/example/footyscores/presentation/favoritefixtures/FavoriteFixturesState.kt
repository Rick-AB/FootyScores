package com.example.footyscores.presentation.favoritefixtures

import com.example.footyscores.domain.model.fixturebydate.Response

data class FavoriteFixturesState(
    val data: List<Response> = emptyList(),
    val error: String? = null
)
