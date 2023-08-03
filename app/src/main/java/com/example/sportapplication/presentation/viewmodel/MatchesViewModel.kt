package com.example.sportapplication.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportapplication.domain.repository.MatchRepository
import com.example.sportapplication.presentation.uistate.MatchesUIState
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

class MatchesViewModel @Inject constructor(
    private val repository: MatchRepository
): ViewModel() {

    private var _uiState = MutableLiveData<MatchesUIState>(MatchesUIState.Initializing)
    val uiState: LiveData<MatchesUIState>
        get() = _uiState

    fun getMatches(leagueId: Int){
        _uiState.value = MatchesUIState.Loading
        viewModelScope.launch {
            try {
                val date = LocalDate.now()
                val from = date.minusDays(7).toString()
                val to = date.plusDays(7).toString()
                val result = repository.getMatches(
                    from,
                    to,
                    leagueId
                )
                _uiState.value = MatchesUIState.Content(result)
            }catch (e: Exception){
                _uiState.value = MatchesUIState.Error(e.message.toString())
            }
        }
    }
}