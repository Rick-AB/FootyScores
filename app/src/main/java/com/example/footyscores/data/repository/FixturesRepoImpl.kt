package com.example.footyscores.data.repository

import com.example.footyscores.data.remote.ApiFootball
import com.example.footyscores.data.remote.dto.fixturebydatedto.ResponseBodyDto
import com.example.footyscores.data.remote.dto.fixturebyiddto.FixtureByIdResponseBodyDto
import com.example.footyscores.domain.repository.FixturesRepo
import javax.inject.Inject

class FixturesRepoImpl @Inject constructor(
    private val apiFootball: ApiFootball
): FixturesRepo {

    override suspend fun getFixturesByDate(date: String): ResponseBodyDto {
        return apiFootball.getFixturesByDate(date)
    }

    override suspend fun getFixtureById(id: Int): FixtureByIdResponseBodyDto {
        return apiFootball.getFixtureById(id)
    }
}