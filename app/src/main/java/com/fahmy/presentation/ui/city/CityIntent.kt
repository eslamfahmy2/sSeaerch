package com.fahmy.presentation.ui.city


sealed class CityIntent {

    object LoadVendors : CityIntent()
    data class Filter(val searchText: String) : CityIntent()
}
