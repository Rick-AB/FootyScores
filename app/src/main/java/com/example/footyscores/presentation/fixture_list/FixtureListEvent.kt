package com.example.footyscores.presentation.fixture_list

sealed class FixtureListEvent {
    object OnRefresh : FixtureListEvent()
    data class OnFavoriteClick(val fixtureId: Int, val favoriteStatus: Boolean) : FixtureListEvent()
}
