package com.example.footyscores.domain.use_case.get_fixture_details

import com.example.footyscores.domain.model.fixturebyid.FixtureDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class GetFixtureDetailsUseCase @Inject constructor(
    private val getFixtureByIdUseCase: GetFixtureByIdUseCase
) {
    suspend operator fun invoke(id: Int): FixtureDetails {
        var fixtureDetails = FixtureDetails()
        supervisorScope {
            launch(Dispatchers.IO) {
                val fixtureById = getFixtureByIdUseCase(id)
                fixtureDetails = fixtureDetails.copy(fixtureByIdResponse = fixtureById)
            }
        }
        return fixtureDetails
    }
}