package com.example.footyscores.presentation.fixture_details

import com.example.footyscores.domain.model.fixturebyid.FixtureByIdResponse

data class FixtureDetailsState(
    val error: String? = null,
    val loading: Boolean = false,
    val fixtureDetails: FixtureByIdResponse = FixtureByIdResponse(),
)
