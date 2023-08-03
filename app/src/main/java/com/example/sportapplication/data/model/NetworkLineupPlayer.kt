package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkLineupPlayer(
    @SerializedName("lineup_player") val lineupPlayer: String,
    @SerializedName("lineup_number") val lineupNumber: String,
    @SerializedName("lineup_position") val lineupPosition: String,
    @SerializedName("player_key") val playerKey: Long
)