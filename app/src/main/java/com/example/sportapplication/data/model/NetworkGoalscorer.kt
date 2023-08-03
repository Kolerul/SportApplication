package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkGoalscorer(
    @SerializedName("time") val time: String,
    @SerializedName("home_scorer") val homeScorer: String,
    @SerializedName("home_scorer_id") val homeScorerId: String,
    @SerializedName("home_assist") val homeAssist: String,
    @SerializedName("home_assist_id") val homeAssistId: String,
    @SerializedName("score") val score: String,
    @SerializedName("away_scorer") val awayScorer: String,
    @SerializedName("away_scorer_id") val awayScorerId: String,
    @SerializedName("away_assist") val awayAssist: String,
    @SerializedName("away_assist_id") val awayAssistId: String,
    @SerializedName("info") val info: String,
    @SerializedName("score_info_time") val scoreInfoTime: String
)