package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkCard(
    @SerializedName("time") val time: String,
    @SerializedName("home_fault") val homeFault: String,
    @SerializedName("card") val card: String,
    @SerializedName("away_fault") val awayFault: String,
    @SerializedName("info") val info: String,
    @SerializedName("home_player_id") val homePlayerId: String,
    @SerializedName("away_player_id") val awayPlayerId: String,
    @SerializedName("score_info_time") val scoreInfoTime: String
)
