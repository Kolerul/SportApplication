package com.example.sportapplication.presentation.uistate

import com.example.sportapplication.domain.entity.Team

sealed class TeamUIState {
    object Initializing : TeamUIState()
    object Loading : TeamUIState()
    data class Content(val team: Team) : TeamUIState()
    data class Error(val errorId: Int) : TeamUIState()
}