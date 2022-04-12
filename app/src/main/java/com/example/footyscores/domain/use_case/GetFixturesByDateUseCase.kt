package com.example.footyscores.domain.use_case

import com.example.footyscores.common.Resource
import com.example.footyscores.domain.model.fixturebydate.Response
import com.example.footyscores.domain.repository.FixturesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFixturesByDateUseCase @Inject constructor(
    private val fixturesRepo: FixturesRepo
) {
    operator fun invoke(date: String): Flow<Resource<List<Response>>> = flow {
        try {
            emit(Resource.Loading())

            val fixturesByDate =
                fixturesRepo.getFixturesByDate(date).response.map { it.toDomainModelResponse() }
            emit(Resource.Success(fixturesByDate))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach server. Please check your internet connection"))
        }
    }
}