package com.example.sportapplication.domain.repository

import com.example.sportapplication.domain.entity.Country

interface CountryRepository {
    suspend fun getCountries(): List<Country>
}