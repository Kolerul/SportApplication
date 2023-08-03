package com.example.sportapplication.domain.repository

import com.example.sportapplication.domain.entity.StandingTeam

interface StandingRepository {
    suspend fun getStanding(leagueId: Int): List<StandingTeam>
}