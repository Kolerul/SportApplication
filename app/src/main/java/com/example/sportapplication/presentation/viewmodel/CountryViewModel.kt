package com.example.sportapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportapplication.R
import com.example.sportapplication.domain.repository.CountryRepository
import com.example.sportapplication.presentation.uistate.CountryUIState
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class CountryViewModel @Inject constructor(
    private val repository: CountryRepository
): ViewModel() {

    private var _uiState = MutableLiveData<CountryUIState>(CountryUIState.Initializing)
    val uiState: LiveData<CountryUIState>
        get() = _uiState

    fun getCountries(){
        _uiState.value = CountryUIState.Loading
        viewModelScope.launch {
            try {
                val result = repository.getCountries()
                _uiState.value = CountryUIState.Content(result)
            } catch (e: UnknownHostException) {
                _uiState.value = CountryUIState.Error(R.string.internet_connection_error)
            } catch (e: SocketTimeoutException) {
                _uiState.value = CountryUIState.Error(R.string.connection_time_error)
            } catch (e: Exception) {
                _uiState.value = CountryUIState.Error(R.string.unknown_error)
            }
        }
    }
}