package com.example.sportapplication.presentation.uistate

import com.example.sportapplication.domain.entity.Match

sealed class MatchesUIState {
    object Initializing: MatchesUIState()
    object Loading: MatchesUIState()
    data class Content(val matches: List<Match>): MatchesUIState()
    data class Error(val errorId: String): MatchesUIState()
}