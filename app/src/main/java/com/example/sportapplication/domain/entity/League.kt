package com.example.sportapplication.domain.entity

data class League(
    val countryId: Int,
    val countryName: String,
    val leagueId: Int,
    val leagueName: String,
     val leagueSeason: String,
    val leagueLogoUri: String,
    val countryLogoUri: String
)