package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkCountry(
    @SerializedName("country_id") val countryId: Int,
    @SerializedName("country_name") val countryName: String,
    @SerializedName("country_logo") val countryLogoUri: String
)