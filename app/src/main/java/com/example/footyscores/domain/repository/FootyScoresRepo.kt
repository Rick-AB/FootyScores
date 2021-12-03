package com.example.footyscores.domain.repository

import com.example.footyscores.data.remote.dto.ResponseDataDto

interface FootyScoresRepo {
    suspend fun getFixturesByDate(date: String): ResponseDataDto
}