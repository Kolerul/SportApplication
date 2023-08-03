package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkCoach(
    @SerializedName("coach_name") val coachName: String,
    @SerializedName("coach_country") val coachCountry: String,
    @SerializedName("coach_age") val coachAge: String
)