package com.example.sportapplication.data.repository

import com.example.sportapplication.data.network.FootballApi
import com.example.sportapplication.data.util.toTeam
import com.example.sportapplication.domain.entity.Team
import com.example.sportapplication.domain.repository.TeamRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val footballApi: FootballApi,
    private val dispatcher: CoroutineDispatcher
): TeamRepository {

    override suspend fun getTeam(teamId: Int): Team = withContext(dispatcher){
        val response = footballApi.getTeam(
            FootballApi.GET_TEAM_ACTION,
            FootballApi.API_KEY,
            teamId
        )

        val team = toTeam(response[0])
        team
    }
}