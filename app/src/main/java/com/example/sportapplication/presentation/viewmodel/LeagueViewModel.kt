package com.example.sportapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportapplication.R
import com.example.sportapplication.domain.repository.LeagueRepository
import com.example.sportapplication.presentation.uistate.LeagueUIState
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException
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
            } catch (e: UnknownHostException) {
                _uiState.value = LeagueUIState.Error(R.string.internet_connection_error)
            } catch (e: SocketTimeoutException) {
                _uiState.value = LeagueUIState.Error(R.string.connection_time_error)
            } catch (e: Exception) {
                _uiState.value = LeagueUIState.Error(R.string.unknown_error)
            }
        }
    }
}