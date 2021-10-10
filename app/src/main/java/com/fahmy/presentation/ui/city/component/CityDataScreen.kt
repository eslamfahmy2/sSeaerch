package com.fahmy.presentation.ui.city.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fahmy.domain.model.City


@Composable
fun CityDataScreen(
    data: List<City>,
    searchText: String,
    onTextChange: (String) -> Unit,
) {

    Column {

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(data) {
                CityItem(city = it, onItemClick = { })
            }
        }

    }


}