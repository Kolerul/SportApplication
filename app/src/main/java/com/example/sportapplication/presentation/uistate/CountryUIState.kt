package com.example.sportapplication.presentation.uistate

import com.example.sportapplication.domain.entity.Country

sealed class CountryUIState {
    object Initializing : CountryUIState()
    object Loading : CountryUIState()
    data class Content(val countries: List<Country>) : CountryUIState()
    data class Error(val errorId: Int) : CountryUIState()
}