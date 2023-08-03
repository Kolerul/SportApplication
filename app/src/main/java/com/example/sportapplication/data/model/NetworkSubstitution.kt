package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkSubstitution(
    @SerializedName("time") val time: String,
    @SerializedName("substitution") val substitution: String,
    @SerializedName("substitution_player_id") val substitutionPlayerId: String
)