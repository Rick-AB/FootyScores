package com.example.footyscores.data.repository

import com.example.footyscores.common.Resource
import com.example.footyscores.data.local.FootyDatabase
import com.example.footyscores.data.remote.ApiFootball
import com.example.footyscores.data.remote.dto.fixturebyiddto.FixtureByIdResponseBodyDto
import com.example.footyscores.data.remote.dto.leaguestandings.LeagueStandingsResponseBodyDto
import com.example.footyscores.domain.model.fixturebydate.Response
import com.example.footyscores.domain.repository.FixturesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FixturesRepoImpl @Inject constructor(
    private val apiFootball: ApiFootball,
    footyDatabase: FootyDatabase
) : FixturesRepo {

    private val dao = footyDatabase.dao
    override fun getFixturesByDate(
        date: String,
        fetchFromNetwork: Boolean
    ): Flow<Resource<List<Response>>> = flow {
        emit(Resource.Loading())
        dao.getFixturesByDate(date).distinctUntilChanged().collect { localFixtures ->
            emit(Resource.Success(localFixtures.map {
                it.toDomainModel()
            }))
            val isDatabaseEmpty = localFixtures.isNullOrEmpty()
            val loadCacheOnly = !isDatabaseEmpty && !fetchFromNetwork
            if (loadCacheOnly) {
                emit(Resource.Loading(false))
                return@collect
            }
            val remoteFixturesEntityModel = try {
                apiFootball.getFixturesByDate(date).response.map {
                    it.toEntityModel().copy(date = date)
                }
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't load fixtures"))
                null
            } catch (e: HttpException) {
                emit(Resource.Error("Couldn't load fixtures"))
                null
            }
            emit(Resource.Loading(false))
            remoteFixturesEntityModel?.let { remoteFixtures ->
                if (isDatabaseEmpty) dao.insertFixtures(remoteFixtures) else dao.updateFixtures(
                    remoteFixtures.map { it.toResponseEntityUpdateModel() }
                )
            }
        }
    }


    override suspend fun getFixtureById(id: Int): FixtureByIdResponseBodyDto {
        return apiFootball.getFixtureById(id)
    }

    override suspend fun getStandingsByLeagueId(
        season: Int,
        leagueId: Int
    ): LeagueStandingsResponseBodyDto {
        return apiFootball.getStaindingsByLeagueId(season, leagueId)
    }

    override suspend fun updateFixtureFavoriteStatus(fixtureId: Int, favoriteStatus: Boolean) {
        dao.updateFixtureFavoriteStatus(fixtureId, favoriteStatus)
    }

    override fun getFavoriteFixture(): Flow<Resource<List<Response>>> = flow {
        dao.getFavoriteFixtures(true).collect { favoriteFixtures ->
            emit(Resource.Success(favoriteFixtures.map { it.toDomainModel() }))
        }
    }
}