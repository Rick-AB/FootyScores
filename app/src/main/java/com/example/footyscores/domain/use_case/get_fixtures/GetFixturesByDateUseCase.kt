package com.example.footyscores.domain.use_case.get_fixtures

import android.util.Log
import com.example.footyscores.common.Resource
import com.example.footyscores.data.remote.dto.ResponseDto
import com.example.footyscores.domain.repository.FootyScoresRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFixturesByDateUseCase @Inject constructor(
    private val footyScoresRepo: FootyScoresRepo
) {
    operator fun invoke(date: String): Flow<Resource<List<ResponseDto>>> = flow {
        try {
            emit(Resource.Loading())

            val fixturesByDate = footyScoresRepo.getFixturesByDate(date).response
//            Log.d("TAG", "invoke: FIXTURES BY DATE: $fixturesByDate")
            emit(Resource.Success(fixturesByDate))
        } catch (e: HttpException) {
//            Log.d("TAG", "invoke: FIXTURES BY DATE ERROR: ${e.localizedMessage}")
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
//            Log.d("TAG", "invoke: FIXTURES BY DATE ERROR: ${e.localizedMessage}")
            emit(Resource.Error("Could not reach server. Please check your internet connection"))
        }
    }
}