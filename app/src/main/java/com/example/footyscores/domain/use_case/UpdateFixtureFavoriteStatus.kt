package com.example.footyscores.domain.use_case

import com.example.footyscores.domain.repository.FixturesRepo
import javax.inject.Inject

class UpdateFixtureFavoriteStatus @Inject constructor(
    private val fixturesRepo: FixturesRepo
) {
    suspend operator fun invoke(fixtureId: Int, favoriteStatus: Boolean) =
        fixturesRepo.updateFixtureFavoriteStatus(fixtureId, favoriteStatus)
}