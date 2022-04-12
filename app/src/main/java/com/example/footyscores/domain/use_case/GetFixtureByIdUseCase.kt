package com.example.footyscores.domain.use_case

import com.example.footyscores.common.Resource
import com.example.footyscores.domain.model.fixturebyid.FixtureByIdResponse
import com.example.footyscores.domain.repository.FixturesRepo
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFixtureByIdUseCase @Inject constructor(
    private val fixturesRepo: FixturesRepo

) {
    suspend operator fun invoke(fixtureId: Int): Resource<FixtureByIdResponse> {
        return try {
            val fixtureById = fixturesRepo.getFixtureById(fixtureId).response[0].toDomainModel()
            Resource.Success(fixtureById)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        } catch (e: IOException) {
            Resource.Error("Could not reach server. Please check your internet connection")
        }
    }
}