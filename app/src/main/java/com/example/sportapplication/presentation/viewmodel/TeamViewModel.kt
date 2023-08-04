package com.example.sportapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportapplication.R
import com.example.sportapplication.domain.repository.TeamRepository
import com.example.sportapplication.presentation.uistate.TeamUIState
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class TeamViewModel @Inject constructor(
    private val repository: TeamRepository
) : ViewModel() {

    private var _uiState = MutableLiveData<TeamUIState>(TeamUIState.Initializing)
    val uiState: LiveData<TeamUIState>
        get() = _uiState

    fun getTeam(teamId: Int) {
        _uiState.value = TeamUIState.Loading
        viewModelScope.launch {
            try {
                val team = repository.getTeam(teamId)
                _uiState.value = TeamUIState.Content(team)
            } catch (e: UnknownHostException) {
                _uiState.value = TeamUIState.Error(R.string.internet_connection_error)
            } catch (e: SocketTimeoutException) {
                _uiState.value = TeamUIState.Error(R.string.connection_time_error)
            } catch (e: Exception) {
                _uiState.value = TeamUIState.Error(R.string.unknown_error)
            }

        }
    }
}