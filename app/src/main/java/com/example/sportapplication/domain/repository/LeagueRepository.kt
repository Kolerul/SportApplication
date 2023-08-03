package com.example.sportapplication.domain.repository

import com.example.sportapplication.domain.entity.League

interface LeagueRepository {
    suspend fun getLeagues(countryId: Int): List<League>
}