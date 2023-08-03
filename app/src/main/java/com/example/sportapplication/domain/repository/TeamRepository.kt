package com.example.sportapplication.domain.repository

import com.example.sportapplication.domain.entity.Team

interface TeamRepository {
    suspend fun getTeam(teamId: Int): Team
}