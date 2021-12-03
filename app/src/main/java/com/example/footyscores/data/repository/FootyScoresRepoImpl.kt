package com.example.footyscores.data.repository

import com.example.footyscores.data.remote.ApiFootball
import com.example.footyscores.data.remote.dto.ResponseDataDto
import com.example.footyscores.domain.repository.FootyScoresRepo
import javax.inject.Inject

class FootyScoresRepoImpl @Inject constructor(
    private val apiFootball: ApiFootball
): FootyScoresRepo {

    override suspend fun getFixturesByDate(date: String): ResponseDataDto {
        return apiFootball.getFixturesByDate(date)
    }
}