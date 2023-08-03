package com.example.sportapplication.data.repository

import com.example.sportapplication.data.network.FootballApi
import com.example.sportapplication.data.util.toCountry
import com.example.sportapplication.domain.entity.Country
import com.example.sportapplication.domain.repository.CountryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val footballApi: FootballApi,
    private val dispatcher: CoroutineDispatcher
): CountryRepository {

    override suspend fun getCountries(): List<Country> = withContext(dispatcher) {
        val response = footballApi.getCountries(
            FootballApi.GET_COUNTRIES_ACTION,
            FootballApi.API_KEY
        )
        val countries = response.map {
            toCountry(it)
        }
        countries
    }
}