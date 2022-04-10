package com.example.footyscores.domain.use_case.get_fixture_details

import com.example.footyscores.common.Resource
import com.example.footyscores.domain.model.fixturebyid.FixtureDetails
import com.example.footyscores.domain.use_case.get_standings.GetStandingsByLeagueId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFixtureDetailsUseCase @Inject constructor(
    private val getFixtureByIdUseCase: GetFixtureByIdUseCase,
    private val getStandingsByLeagueId: GetStandingsByLeagueId
) {
    suspend operator fun invoke(id: Int): FixtureDetails {
        var fixtureDetails = FixtureDetails()
        withContext(Dispatchers.IO) {
            val fixtureByIdResponse = getFixtureByIdUseCase(id)
            fixtureDetails = fixtureDetails.copy(fixtureByIdResponse = fixtureByIdResponse)
            if (fixtureByIdResponse is Resource.Success) {
                val isLeague = fixtureByIdResponse.data?.league?.country != "world"
                if (isLeague) {
                    val season = fixtureByIdResponse.data?.league?.season!!
                    val leagueId = fixtureByIdResponse.data.league.id!!
                    val standingsByLeagueIdResponse = getStandingsByLeagueId(season, leagueId)
                    fixtureDetails =
                        fixtureDetails.copy(leagueStandingsByLeagueIdResponse = standingsByLeagueIdResponse)
                }
            }
        }
        return fixtureDetails
    }
}