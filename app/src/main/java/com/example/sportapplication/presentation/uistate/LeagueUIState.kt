package com.example.sportapplication.presentation.uistate

import com.example.sportapplication.domain.entity.League

sealed class LeagueUIState {
    object Initializing: LeagueUIState()
    object Loading: LeagueUIState()
    data class Content(val leagues: List<League>): LeagueUIState()
    data class Error(val errorId: String): LeagueUIState()
}