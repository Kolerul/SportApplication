package com.example.sportapplication.data.repository

import com.example.sportapplication.data.network.FootballApi
import com.example.sportapplication.data.util.toStandingTeam
import com.example.sportapplication.domain.entity.StandingTeam
import com.example.sportapplication.domain.repository.StandingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StandingRepositoryImpl @Inject constructor(
    private val footballApi: FootballApi,
    private val dispatcher: CoroutineDispatcher
): StandingRepository {

    override suspend fun getStanding(leagueId: Int): List<StandingTeam> = withContext(dispatcher){
        val response = footballApi.getStanding(
            FootballApi.GET_STANDINGS_ACTION,
            FootballApi.API_KEY,
            leagueId
        )

        val standing = response.map {
            toStandingTeam(it)
        }
        standing
    }
}