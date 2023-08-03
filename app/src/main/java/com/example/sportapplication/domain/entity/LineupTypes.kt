package com.example.sportapplication.domain.entity


data class LineupTypes(
    val startingLineups: List<LineupPlayer>,
    val substitutes: List<LineupPlayer>,
    val coach: List<LineupPlayer>,
    val missingPlayers: List<LineupPlayer>
)