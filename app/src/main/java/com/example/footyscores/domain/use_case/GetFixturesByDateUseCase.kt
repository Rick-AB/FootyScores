package com.example.footyscores.domain.use_case

import com.example.footyscores.common.Resource
import com.example.footyscores.domain.model.fixturebydate.Response
import com.example.footyscores.domain.repository.FixturesRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFixturesByDateUseCase @Inject constructor(
    private val fixturesRepo: FixturesRepo,
) {
    operator fun invoke(
        date: String,
        fetchFromNetwork: Boolean = false
    ): Flow<Resource<List<Response>>> =
        fixturesRepo.getFixturesByDate(date, fetchFromNetwork)
}