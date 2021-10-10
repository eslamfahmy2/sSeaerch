package com.fahmy.presentation.ui.city

import com.fahmy.domain.model.City


sealed class CityState {
    data class Success(val data: List<City> = listOf()) : CityState()
    data class Error(val message: String? = null) : CityState()
    object Loading : CityState()
}