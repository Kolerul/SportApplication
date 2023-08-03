package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkLeague(
    @SerializedName("country_id") val countryId: Int,
    @SerializedName("country_name") val countryName: String,
    @SerializedName("league_id") val leagueId: Int,
    @SerializedName("league_name") val leagueName: String,
    @SerializedName("league_season") val leagueSeason: String,
    @SerializedName("league_logo") val leagueLogoUri: String,
    @SerializedName("country_logo") val countryLogoUri: String
)