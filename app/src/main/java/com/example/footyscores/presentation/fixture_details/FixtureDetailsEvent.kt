package com.example.footyscores.presentation.fixture_details

sealed class FixtureDetailsEvent {
    object OnRefresh : FixtureDetailsEvent()
    data class OnScreenLoad(val fixtureId: Int) : FixtureDetailsEvent()
}
