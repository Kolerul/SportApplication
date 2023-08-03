package com.example.sportapplication.domain.entity


data class Team(
    val teamKey: Int,
    val teamName: String,
    val teamBadgeUri: String,
    val players: List<Player>,
    val coaches: List<Coach>
)