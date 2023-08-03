package com.example.sportapplication.data.network

import com.example.sportapplication.data.model.NetworkCountry
import com.example.sportapplication.data.model.NetworkMatch
import com.example.sportapplication.data.model.NetworkLeague
import com.example.sportapplication.data.model.NetworkStandingTeam
import com.example.sportapplication.data.model.NetworkTeam
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApi {

    @GET("/")
    suspend fun getCountries(
        @Query("action") action: String,
        @Query("APIkey") apiKey: String
    ): List<NetworkCountry>

    @GET("/")
    suspend fun getLeagues(
        @Query("action") action: String,
        @Query("APIkey") apiKey: String,
        @Query("country_id") countryId: Int
    ): List<NetworkLeague>

    @GET("/")
    suspend fun getStanding(
        @Query("action") action: String,
        @Query("APIkey") apiKey: String,
        @Query("league_id") leagueId: Int
    ): List<NetworkStandingTeam>

    @GET("/")
    suspend fun getTeam(
        @Query("action") action: String,
        @Query("APIkey") apiKey: String,
        @Query("team_id") teamId: Int,
    ): List<NetworkTeam>

    @GET("/")
    suspend fun getMatches(
        @Query("action") action: String,
        @Query("from") fromDate: String,
        @Query("to") toDate: String,
        @Query("league_id") leagueId: Int,
        @Query("APIkey") apiKey: String,
    ): List<NetworkMatch>

    companion object{
        const val BASE_URL = "https://apiv3.apifootball.com"
        const val API_KEY = "1251510d5f0c6d4cad361c9665154b4fa6fdc028ed0301a8dede3a45e9739377"
        const val GET_COUNTRIES_ACTION = "get_countries"
        const val GET_LEAGUES_ACTION = "get_leagues"
        const val GET_MATCHES_ACTION = "get_events"
        const val GET_STANDINGS_ACTION = "get_standings"
        const val GET_TEAM_ACTION = "get_teams"
    }
}