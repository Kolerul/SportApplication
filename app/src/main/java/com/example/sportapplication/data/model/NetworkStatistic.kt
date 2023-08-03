package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkStatistic(
    @SerializedName("type") val type: String,
    @SerializedName("home") val home: String,
    @SerializedName("away") val away: String
)