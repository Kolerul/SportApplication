package com.example.sportapplication.data.model

import com.google.gson.annotations.SerializedName

data class NetworkSubstitutionsList(
    @SerializedName("home") val homeList: List<NetworkSubstitution>,
    @SerializedName("away") val awayList: List<NetworkSubstitution>
)