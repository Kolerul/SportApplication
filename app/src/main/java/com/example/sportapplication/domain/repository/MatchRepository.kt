package com.example.sportapplication.domain.repository

import com.example.sportapplication.domain.entity.Match

interface MatchRepository {
    suspend fun getMatches(from: String, to: String, leagueId: Int): List<Match>
}