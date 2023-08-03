package com.example.sportapplication.data.repository

import com.example.sportapplication.data.network.FootballApi
import com.example.sportapplication.data.util.toLeague
import com.example.sportapplication.domain.entity.League
import com.example.sportapplication.domain.repository.LeagueRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LeagueRepositoryImpl @Inject constructor(
    private val footballApi: FootballApi,
    private val dispatcher: CoroutineDispatcher
): LeagueRepository {

    override suspend fun getLeagues(countryId: Int): List<League> = withContext(dispatcher){
        val response = footballApi.getLeagues(
            FootballApi.GET_LEAGUES_ACTION,
            FootballApi.API_KEY,
            countryId
        )

        val leagues = response.map {
            toLeague(it)
        }
        leagues
    }
}