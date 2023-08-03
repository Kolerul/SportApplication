package com.example.sportapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportapplication.domain.repository.LeagueRepository
import com.example.sportapplication.presentation.uistate.LeagueUIState
import kotlinx.coroutines.launch
import javax.inject.Inject

class LeagueViewModel @Inject constructor(
    private val repository: LeagueRepository
): ViewModel() {

    private var _uiState = MutableLiveData<LeagueUIState>(LeagueUIState.Initializing)
    val uiState: LiveData<LeagueUIState>
        get() = _uiState

    fun getLeagues(leagueId: Int){
        _uiState.value = LeagueUIState.Loading
        viewModelScope.launch {
            try {
                val result = repository.getLeagues(
                    leagueId
                )
                _uiState.value = LeagueUIState.Content(result)
            }catch (e: Exception){
                _uiState.value = LeagueUIState.Error(e.message.toString())
            }
        }
    }
}