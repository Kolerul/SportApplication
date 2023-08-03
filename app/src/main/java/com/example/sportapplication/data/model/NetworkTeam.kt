package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkTeam(
    @SerializedName("team_key") val teamKey: Int,
    @SerializedName("team_name") val teamName: String,
    @SerializedName("team_badge") val teamBadgeUri: String,
    @SerializedName("players") val players: List<NetworkPlayer>,
    @SerializedName("coaches") val coaches: List<NetworkCoach>
)