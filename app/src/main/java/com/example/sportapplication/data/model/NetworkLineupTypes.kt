package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkLineupTypes(
    @SerializedName("starting_lineups") val startingLineups: List<NetworkLineupPlayer>,
    @SerializedName("substitutes") val substitutes: List<NetworkLineupPlayer>,
    @SerializedName("coach") val coach: List<NetworkLineupPlayer>,
    @SerializedName("missing_players") val missingPlayers: List<NetworkLineupPlayer>
)