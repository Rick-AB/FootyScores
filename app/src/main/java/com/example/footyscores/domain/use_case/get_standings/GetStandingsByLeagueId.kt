package com.example.footyscores.domain.use_case.get_standings

import com.example.footyscores.common.Resource
import com.example.footyscores.domain.model.leaguestandings.LeagueStandingsResponse
import com.example.footyscores.domain.repository.FixturesRepo
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStandingsByLeagueId @Inject constructor(
    private val fixturesRepo: FixturesRepo
) {
    suspend operator fun invoke(season: Int, leagueId: Int): Resource<LeagueStandingsResponse> {
        return try {
            val result =
                fixturesRepo.getStandingsByLeagueId(season, leagueId).response[0].toDomainModel()
            Resource.Success(result)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        } catch (e: IOException) {
            Resource.Error("Could not reach server. Please check your internet connection")
        }
    }
}