package com.example.sportapplication.domain.entity

import com.google.gson.annotations.SerializedName

data class Coach(
    val coachName: String,
    val coachCountry: String,
    val coachAge: Int
)