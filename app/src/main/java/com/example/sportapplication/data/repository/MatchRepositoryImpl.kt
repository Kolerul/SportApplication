package com.example.sportapplication.data.repository

import com.example.sportapplication.data.network.FootballApi
import com.example.sportapplication.data.util.toMatch
import com.example.sportapplication.domain.entity.Match
import com.example.sportapplication.domain.repository.MatchRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val footballApi: FootballApi,
    private val dispatcher: CoroutineDispatcher
): MatchRepository {

    override suspend fun getMatches(from: String, to: String, leagueId: Int): List<Match> = withContext(dispatcher){
        val response = footballApi.getMatches(
            FootballApi.GET_MATCHES_ACTION,
            from,
            to,
            leagueId,
            FootballApi.API_KEY
        )

        val matches = response.map {
            toMatch(it)
        }
        matches
    }

}