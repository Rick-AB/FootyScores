package com.example.footyscores.domain.repository

import com.example.footyscores.data.remote.dto.fixturebydatedto.ResponseBodyDto
import com.example.footyscores.data.remote.dto.fixturebyiddto.FixtureByIdResponseBodyDto

interface FixturesRepo {
    suspend fun getFixturesByDate(date: String): ResponseBodyDto
    suspend fun getFixtureById(id: Int): FixtureByIdResponseBodyDto
}