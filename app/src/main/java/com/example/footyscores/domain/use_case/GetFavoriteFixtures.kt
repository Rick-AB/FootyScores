package com.example.footyscores.domain.use_case

import com.example.footyscores.domain.repository.FixturesRepo
import javax.inject.Inject

class GetFavoriteFixtures @Inject constructor(
    private val fixturesRepo: FixturesRepo
) {
    operator fun invoke() = fixturesRepo.getFavoriteFixture()
}