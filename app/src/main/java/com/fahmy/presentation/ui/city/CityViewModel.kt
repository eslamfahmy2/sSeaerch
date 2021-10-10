package com.fahmy.presentation.ui.city

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahmy.data.utils.DataState
import com.fahmy.domain.useCase.SearchCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "CityViewModel"

@HiltViewModel
class CityViewModel @Inject constructor(
    private val useCase: SearchCitiesUseCase,
) : ViewModel() {


    val userIntent = Channel<CityIntent>(Channel.UNLIMITED)

    private val _state: MutableState<CityState> = mutableStateOf(CityState.Loading)
    val state get() = _state

    private val _searchText: MutableState<String> = mutableStateOf("cairo")
    val query get() = _searchText

    init {
        handleIntent()
        viewModelScope.launch {
            loadCities()
        }
    }

    private fun handleIntent() {
        viewModelScope.launch {

            userIntent.consumeAsFlow().collect { intent ->
                when (intent) {
                    CityIntent.LoadVendors -> {
                        loadCities()
                    }
                    is CityIntent.Filter -> {
                        filter(intent.searchText)
                    }
                }
            }
        }
    }

    private suspend fun loadCities() {

        useCase(_searchText.value).collect { dataState ->
            when (dataState) {
                is DataState.Error -> {
                    Log.d(TAG, "Error: " + dataState.message)
                    _state.value = CityState.Error(dataState.message)
                }
                is DataState.Loading -> {
                    _state.value = CityState.Loading
                }
                is DataState.Success -> {
                    _state.value = CityState.Success(data = dataState.data ?: listOf())
                }
            }
        }
    }

    private suspend fun filter(searchText: String) {
        _searchText.value = searchText
        loadCities()
    }

}