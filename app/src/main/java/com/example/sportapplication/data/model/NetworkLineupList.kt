package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkLineupList(
    @SerializedName("home") val home: NetworkLineupTypes,
    @SerializedName("away") val away: NetworkLineupTypes
)